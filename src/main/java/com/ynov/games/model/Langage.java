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
@Table(name = "langages")
public class Langage {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_langage")
	private Integer id_langage;
	
	@Column(name = "name")
	private String name;
	
	@ManyToMany(mappedBy = "langages")
	@JsonIgnore
	private Set<Game> games = new HashSet<>();
	
	
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

	public Set<Game> getGames() {
		return games;
	}

	public void setGames(Set<Game> games) {
		this.games = games;
    }
	
	
	

}
