package com.co.edu.udea.granjamintic.sistema.seguridad;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class Configuracion {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.authorizeRequests()
        	      .mvcMatchers("/").permitAll()
        	      .anyRequest().authenticated()
        	      .and().oauth2Login()
        	      .and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
        	      .and().build();
    }
}
