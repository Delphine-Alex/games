package com.ynov.games.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "illustrators")
public class Illustrator {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_illustrator")
	private Integer id_illustrator;
	
	@Column(name = "name")
	private String name;

	
	// Getters and setters
	
	
	public Integer getId_illustrator() {
		return id_illustrator;
	}
	
	public void setId_illustrator(Integer id_illustrator) {
		this.id_illustrator = id_illustrator;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

}
