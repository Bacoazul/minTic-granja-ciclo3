package com.co.edu.udea.granjamintic.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.co.edu.udea.granjamintic.modelo.Persona;
import com.co.edu.udea.granjamintic.servicio.PersonaServicio;

@RestController
@RequestMapping("/persona")
public class PersonaControlador {
	
	@Autowired
	private PersonaServicio personaServicio;
	
	@GetMapping("/administradores")
	public ResponseEntity<List<Persona>> obtenerAdministradores() {
		List<Persona> administradores = personaServicio.obtenerAdministradores();
		if (administradores.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(administradores);
	}

	@GetMapping
	public ResponseEntity<List<Persona>> obtenerMayordomosPorGranja(Integer idGranja) {
		List<Persona> mayordomos = personaServicio.obtenerMayordomosPorGranja(idGranja);
		if (mayordomos.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(mayordomos);
	}

	@PostMapping
	public Persona guardarPersona(@RequestBody Persona persona) {
		return personaServicio.guardarPersona(persona);
	}

	@PutMapping("/granja")
	public void agregarGranjaComoMayordomo(Integer idPersona, Integer idGranja) {
		personaServicio.agregarGranjaComoMayordomo(idPersona, idGranja);
	}

	@PutMapping("/celular")
	public void actualizarCelular(Integer idPersona, String celular) {
		personaServicio.actualizarCelularConSave(idPersona, celular);
	}

}
