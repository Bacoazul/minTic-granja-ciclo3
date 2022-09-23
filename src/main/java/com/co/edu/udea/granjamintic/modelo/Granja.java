package com.co.edu.udea.granjamintic.modelo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "GRANJAS")
@AllArgsConstructor
@NoArgsConstructor
public class Granja {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false)
	private String nombre;

	@Column(nullable = false)
	private String descripcion;
	
	@ManyToOne
    @JoinColumn(name = "ADMINISTRADOR_ID")
	private Persona administrador;
	
	@JsonIgnore
	@ManyToMany
    @JoinTable(
            name = "MAYORDOMOS",
            joinColumns = {@JoinColumn(name = "GRANJA_ID")},
            inverseJoinColumns = {@JoinColumn(name = "PERSONA_ID")}
    )
	private List<Persona> mayordomos;
	

	@JsonIgnore
	@OneToMany(mappedBy = "granja")
	private List<Animal> animales;

}
