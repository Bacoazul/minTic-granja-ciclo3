package com.co.edu.udea.granjamintic.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.co.edu.udea.granjamintic.modelo.Especie;

@Repository
public interface EspecieRepositorio extends JpaRepository<Especie, Integer> {

}
