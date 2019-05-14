package com.sim.apisim.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "almoxarifados", schema = "sspdb")
public class Almoxarifado {

	@Id
	@GeneratedValue
	@Column(name = "alxIdAlmoxarifado", unique = true)
	private int id;

	@Column(name = "alxNome", nullable = false, length = 100)
	private String nome;

	@Column(name = "empidEmpresas", nullable = false)
	private int empresaId;

}
