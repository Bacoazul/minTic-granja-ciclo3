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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "PERSONAS")
@NoArgsConstructor
public class Persona {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false, unique = true)
	private String outh0Id;

	@Column(nullable = false)
	private String nombres;

	@Column(nullable = false)
	private String apellidos;

	@Column(nullable = false)
	private String correoElectronico;

	@Column(nullable = false, length = 1000)
	private String urlFoto;

	@Column
	private String celular;

	@Column(nullable = false)
	private Rol rol;
	
	@JsonIgnore
	@ManyToMany
    @JoinTable(
            name = "MAYORDOMOS",
            joinColumns = {@JoinColumn(name = "PERSONA_ID")},
            inverseJoinColumns = {@JoinColumn(name = "GRANJA_ID")}
    )
	private List<Granja> granjasComoMayordomo;

	public Persona(String outh0Id, String nombres, String apellidos, String correoElectronico, String urlFoto,
			Rol rol) {
		this.outh0Id = outh0Id;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.correoElectronico = correoElectronico;
		this.urlFoto = urlFoto;
		this.rol = rol;
	}
	
	
}
