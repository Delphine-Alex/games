package com.ynov.games.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "editors")
public class Editor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_editor")
	private Integer id_editor;
	
	@Column(name = "name")
	private String name;
	
	
	// Getters and setters

	
	public Integer getId_editor() {
		return id_editor;
	}

	public void setId_editor(Integer id_editor) {
		this.id_editor = id_editor;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

}
