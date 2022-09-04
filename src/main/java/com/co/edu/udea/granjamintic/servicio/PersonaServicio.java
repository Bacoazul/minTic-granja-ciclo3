package com.co.edu.udea.granjamintic.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.co.edu.udea.granjamintic.modelo.Persona;
import com.co.edu.udea.granjamintic.modelo.Rol;
import com.co.edu.udea.granjamintic.repositorio.PersonaRepositorio;

@Service
public class PersonaServicio {
	
	@Autowired
	private PersonaRepositorio personaRepositorio;
	
	public List<Persona> obtenerAdministradores() {
		return personaRepositorio.findByRol(Rol.ADMINISTRADOR);
	}
	
	public List<Persona> obtenerMayordomosPorGranja(Integer idGranja) {
		return personaRepositorio.findByGranjasComoMayordomoId(idGranja);
	}

	public Persona guardarPersona(Persona persona) {
		return personaRepositorio.save(persona);
	}

	public void agregarGranjaComoMayordomo(Integer idPersona, Integer idGranja) {
		personaRepositorio.agregarGranjaComoMayordomo(idPersona, idGranja);
	}

	public void actualizarCelular(Integer idPersona, String telefono) {
		personaRepositorio.actualizarCelular(idPersona, telefono);
	}

	public void actualizarCelularConSave(Integer idPersona, String celular) {
		Optional<Persona> personaOptional = personaRepositorio.findById(idPersona);
		if (personaOptional.isPresent()) {
			Persona persona = personaOptional.get();
			persona.setCelular(celular);
			personaRepositorio.save(persona);
		}
		
	}

}
