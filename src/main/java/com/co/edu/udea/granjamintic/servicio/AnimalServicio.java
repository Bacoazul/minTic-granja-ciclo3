package com.co.edu.udea.granjamintic.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.co.edu.udea.granjamintic.modelo.Animal;
import com.co.edu.udea.granjamintic.repositorio.AnimalRepositorio;

@Service
public class AnimalServicio {
	
	@Autowired
	private AnimalRepositorio animalRepositorio;

	public Animal guardarAnimal(Animal animal) {
		return animalRepositorio.save(animal);
	}

}
