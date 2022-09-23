package com.co.edu.udea.granjamintic.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.co.edu.udea.granjamintic.modelo.Especie;
import com.co.edu.udea.granjamintic.repositorio.EspecieRepositorio;

@Service
public class EspecieServicio {
	
	@Autowired
	private EspecieRepositorio especieRepositorio;

	public List<Especie> obtenerEspecies() {
		return especieRepositorio.findAll();
	}

}
