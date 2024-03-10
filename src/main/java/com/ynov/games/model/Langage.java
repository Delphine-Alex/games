package com.ynov.games.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "langages")
public class Langage {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_langage")
	private Integer id_langage;
	
	@Column(name = "name")
	private String name;
	
	
	// Getters and setters

	
	public Integer getId_langage() {
		return id_langage;
	}

	public void setId_langage(Integer id_langage) {
		this.id_langage = id_langage;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
