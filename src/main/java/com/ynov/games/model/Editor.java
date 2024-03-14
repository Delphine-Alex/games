package com.ynov.games.model;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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
	
	@ManyToMany(mappedBy = "editors")
	@JsonIgnore
	private Set<Game> games = new HashSet<>();
	
	
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

	public Set<Game> getGames() {
		return games;
	}

	public void setGames(Set<Game> games) {
		this.games = games;
	}
	
	

}
