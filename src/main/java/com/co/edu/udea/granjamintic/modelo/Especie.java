package com.co.edu.udea.granjamintic.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ESPECIES")
@AllArgsConstructor
@NoArgsConstructor
public class Especie {
	
	@Id
	private Integer id;
	
	@Column(nullable = false)
	private String nombre;

	@Column(nullable = true)
	private String temperamento;

}
