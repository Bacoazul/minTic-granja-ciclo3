package com.co.edu.udea.granjamintic.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.co.edu.udea.granjamintic.modelo.Granja;
import com.co.edu.udea.granjamintic.servicio.GranjaServicio;

@RestController
@RequestMapping("/granja")
public class GranjaControlador {
	
	@Autowired
	private GranjaServicio granjaServicio;
	
	@GetMapping("/todas")
	public ResponseEntity<List<Granja>> obtenerGranjas() {
		List<Granja> granjas = granjaServicio.obtenerGranjas();
		if (granjas.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(granjas);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Granja> obtenerGranjaPorId(@PathVariable Integer id) {
		Optional<Granja> granja = granjaServicio.obtenerGranjaPorId(id);
		return granja.isPresent() ? ResponseEntity.ok(granja.get()) : ResponseEntity.notFound().build();
	}

	@GetMapping("/filtrado")
	public ResponseEntity<Granja> obtenerGranjaFiltrado(@RequestParam(required = false) String nombre, @RequestParam(required = false) Integer idAdministrador) {
		Optional<Granja> granja = granjaServicio.obtenerGranjaFiltrado(nombre, idAdministrador);
		return granja.isPresent() ? ResponseEntity.ok(granja.get()) : ResponseEntity.notFound().build();
	}

	@PostMapping
	public Granja guardarGranja(@RequestBody Granja granja) {
		return granjaServicio.guardarGranja(granja);
	}

}
