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
@Table(name = "mechanisms")
public class Mechanism {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_mechanism")
	private Integer id_mechanism;
	
	@Column(name = "name")
	private String name;
	
	@ManyToMany(mappedBy = "mechanisms")
	@JsonIgnore
	private Set<Game> games = new HashSet<>();
	

	// Getters and setters	
	
	
	public Integer getId_mechanism() {
		return id_mechanism;
	}

	public void setId_mechanism(Integer id_mechanism) {
		this.id_mechanism = id_mechanism;
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
