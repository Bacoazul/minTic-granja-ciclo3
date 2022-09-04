package com.co.edu.udea.granjamintic.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.co.edu.udea.granjamintic.modelo.Granja;

@Repository
public interface GranjaRepositorio extends JpaRepository<Granja, Integer> {

	Optional<Granja> findByNombre(String nombre);

	Optional<Granja> findByAdministradorId(Integer idAdministrador);

}
