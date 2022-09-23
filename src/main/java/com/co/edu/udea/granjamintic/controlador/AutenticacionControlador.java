package com.co.edu.udea.granjamintic.controlador;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.co.edu.udea.granjamintic.modelo.Granja;
import com.co.edu.udea.granjamintic.modelo.Persona;
import com.co.edu.udea.granjamintic.servicio.PersonaServicio;
import com.co.edu.udea.granjamintic.servicio.GranjaServicio;
import com.co.edu.udea.granjamintic.sistema.utils.PersonaBuilder;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class AutenticacionControlador {
	
	private final PersonaServicio personaServicio;
	private final GranjaServicio granjaServicio;

	@GetMapping("/")
    public String iniciar (Model model, @AuthenticationPrincipal OidcUser principal) {
		if (principal == null) {
	        return "autenticacion";
		}
		Persona persona = PersonaBuilder.convertirAEntidad(principal.getUserInfo());
		persona = personaServicio.guardarPersona(persona);
		Granja granja = granjaServicio.obtenerGranjaFiltrado(null, persona.getId()).orElse(null);
		model.addAttribute(persona);
		model.addAttribute("granja", granja);
        return "home";
    }

}
