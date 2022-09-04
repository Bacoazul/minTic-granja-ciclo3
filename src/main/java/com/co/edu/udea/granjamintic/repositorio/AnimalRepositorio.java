package com.co.edu.udea.granjamintic.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.co.edu.udea.granjamintic.modelo.Animal;

@Repository
public interface AnimalRepositorio extends JpaRepository<Animal, Integer> {

}
