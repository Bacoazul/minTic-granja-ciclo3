package com.co.edu.udea.granjamintic.controlador;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.co.edu.udea.granjamintic.modelo.Persona;
import com.co.edu.udea.granjamintic.servicio.PersonaServicio;
import com.co.edu.udea.granjamintic.sistema.utils.PersonaBuilder;

@Controller
public class AutenticacionControlador {
	
	private final PersonaServicio personaServicio;
	
	public AutenticacionControlador(PersonaServicio personaServicio) {
		this.personaServicio = personaServicio;
	}

	@GetMapping("/")
    public String iniciar (Model model, @AuthenticationPrincipal OidcUser principal) {
		if (principal == null) {
	        return "autenticacion";
		}
		Persona persona = PersonaBuilder.convertirAEntidad(principal.getUserInfo());
		personaServicio.guardarPersona(persona);
		model.addAttribute(persona);
        return "home";
    }

}
