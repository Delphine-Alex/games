package com.ynov.games.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "creators")
public class Creator {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_creator")
	private Integer id_creator;
	
	@Column(name = "name")
	private String name;
	
	
	// Getters and setters

	
	public Integer getId_creator() {
		return id_creator;
	}

	public void setId_creator(Integer id_creator) {
		this.id_creator = id_creator;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
