package com.ynov.games.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
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
	
	@OneToMany(
			cascade = CascadeType.ALL,
			fetch = FetchType.EAGER,
			orphanRemoval = true
			)
	@JoinColumn(name = "id_creator")
	
	private List<Game> games = new ArrayList<>();
	
	
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

	public List<Game> getGames() {
		return games;
	}

	public void setGames(List<Game> games) {
		this.games = games;
	}


	
	
}
