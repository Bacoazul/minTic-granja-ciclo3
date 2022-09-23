package com.co.edu.udea.granjamintic.repositorio;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.co.edu.udea.granjamintic.modelo.Persona;
import com.co.edu.udea.granjamintic.modelo.Rol;

@Repository
public interface PersonaRepositorio extends JpaRepository<Persona, Integer> {

	List<Persona> findByRol(Rol administrador);

	List<Persona> findByGranjasComoMayordomoId(Integer idGranja);

	@Query(value = "INSERT INTO MAYORDOMOS (PERSONA_ID, GRANJA_ID) VALUES (:idPersona, :idGranja)", nativeQuery = true)
	@Modifying(clearAutomatically = true)
	@Transactional
	void agregarGranjaComoMayordomo(Integer idPersona, Integer idGranja);

	@Query(value = "update Persona set celular = :celular where id = :idPersona", nativeQuery = false)
	@Modifying(clearAutomatically = true)
	@Transactional
	void actualizarCelular(Integer idPersona, String celular);

	Optional<Persona> findByOuth0Id(String outh0Id);

}
