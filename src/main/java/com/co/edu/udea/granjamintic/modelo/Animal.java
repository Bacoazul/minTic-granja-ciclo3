package com.co.edu.udea.granjamintic.modelo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ANIMALES")
@AllArgsConstructor
@NoArgsConstructor
public class Animal {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
    @JoinColumn(name = "ESPECIE_ID")
	private Especie especie;
	
	@ManyToOne
    @JoinColumn(name = "GRANJA_ID")
	private Granja granja;

	@Column(nullable = false)
	@DateTimeFormat(iso=ISO.DATE)
	private Date fechaNacimiento;

	@Column(nullable = false)
	private String estadoSalud;

	@Column(nullable = false)
	private String descripcion;
	
	@Column(nullable = true)
	@DateTimeFormat(iso=ISO.DATE)
	private Date ultimaVacuna;

}
