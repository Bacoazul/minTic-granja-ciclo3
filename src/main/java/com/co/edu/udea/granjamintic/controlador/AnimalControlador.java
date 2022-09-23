package com.co.edu.udea.granjamintic.controlador;

import javax.validation.Valid;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.co.edu.udea.granjamintic.modelo.Animal;
import com.co.edu.udea.granjamintic.modelo.Granja;
import com.co.edu.udea.granjamintic.modelo.Persona;
import com.co.edu.udea.granjamintic.servicio.AnimalServicio;
import com.co.edu.udea.granjamintic.servicio.EspecieServicio;
import com.co.edu.udea.granjamintic.servicio.GranjaServicio;
import com.co.edu.udea.granjamintic.servicio.PersonaServicio;
import com.co.edu.udea.granjamintic.sistema.utils.PersonaBuilder;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/animal")
@AllArgsConstructor
public class AnimalControlador {
	
	private final PersonaServicio personaServicio;
	private final GranjaServicio granjaServicio;
	private final EspecieServicio especieServicio;
	private final AnimalServicio animalServicio;
	
	@GetMapping
    public String iniciarFormulario (Model model, @AuthenticationPrincipal OidcUser principal) {
        model.addAttribute("animal", new Animal());
		model.addAttribute("especies", especieServicio.obtenerEspecies());
        return "nuevo-animal";
    }
	
	@PostMapping
    public ModelAndView agregarNuevoAnimal (@Valid Animal animal, BindingResult result, @AuthenticationPrincipal OidcUser principal) {
		ModelAndView model = new ModelAndView();
		Persona persona = PersonaBuilder.convertirAEntidad(principal.getUserInfo());
		persona = personaServicio.guardarPersona(persona);
		Granja granja = granjaServicio.obtenerGranjaFiltrado(null, persona.getId()).orElse(null);
		animal.setGranja(granja);
		animalServicio.guardarAnimal(animal);
        model.setViewName(result.hasErrors() ? "animal" : "granja"); 
        return model;
    }

}
