package com.co.edu.udea.granjamintic.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.co.edu.udea.granjamintic.modelo.Granja;
import com.co.edu.udea.granjamintic.repositorio.GranjaRepositorio;

@Service
public class GranjaServicio {
	
	@Autowired
	private GranjaRepositorio granjaRepositorio;
	
	public List<Granja> obtenerGranjas() {
		return granjaRepositorio.findAll();
	}
	
	public Optional<Granja> obtenerGranjaPorId(Integer id) {
		return granjaRepositorio.findById(id);
	}

	public Optional<Granja> obtenerGranjaFiltrado(String nombre, Integer idAdministrador) {
		if (nombre != null) {
			return granjaRepositorio.findByNombre(nombre);
		}
		if (idAdministrador != null) {
			return granjaRepositorio.findByAdministradorId(idAdministrador);
		}
		return Optional.empty();
	}

	public Granja guardarGranja(Granja granja) {
		return granjaRepositorio.save(granja);
	}

}
