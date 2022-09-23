package com.co.edu.udea.granjamintic.controlador;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.co.edu.udea.granjamintic.modelo.Granja;
import com.co.edu.udea.granjamintic.modelo.Persona;
import com.co.edu.udea.granjamintic.servicio.GranjaServicio;
import com.co.edu.udea.granjamintic.servicio.PersonaServicio;
import com.co.edu.udea.granjamintic.sistema.utils.PersonaBuilder;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/granja")
@AllArgsConstructor
public class GranjaControlador {
	
	private final PersonaServicio personaServicio;
	private final GranjaServicio granjaServicio;
	
	@GetMapping
    public String administrarGranja (Model model, @AuthenticationPrincipal OidcUser principal) {
		Persona persona = PersonaBuilder.convertirAEntidad(principal.getUserInfo());
		persona = personaServicio.guardarPersona(persona);
		Granja granja = granjaServicio.obtenerGranjaFiltrado(null, persona.getId()).orElse(null);
		model.addAttribute("granja", granja);
		model.addAttribute("animales", granja.getAnimales());
        return "granja";
    }

}
