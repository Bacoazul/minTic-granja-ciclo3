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

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "PERSONAS")
@AllArgsConstructor
@NoArgsConstructor
public class Persona {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false)
	private String nombres;

	@Column(nullable = false)
	private String apellidos;

	@Column(nullable = false)
	private String correoElectronico;

	@Column(nullable = false)
	private String celular;

	@Column(nullable = false)
	private Rol rol;
	
	@ManyToMany
    @JoinTable(
            name = "MAYORDOMOS",
            joinColumns = {@JoinColumn(name = "PERSONA_ID")},
            inverseJoinColumns = {@JoinColumn(name = "GRANJA_ID")}
    )
	private List<Granja> granjasComoMayordomo;
}
