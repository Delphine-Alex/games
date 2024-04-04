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
@Table(name = "illustrators")
public class Illustrator {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_illustrator")
	private Integer id_illustrator;
	
	@Column(name = "name")
	private String name;
	
	@OneToMany(
			cascade = CascadeType.ALL,
			fetch = FetchType.EAGER,
			orphanRemoval = true
			)
	@JoinColumn(name = "id_illustrator")
	
	private List<Game> games = new ArrayList<>();
	

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

	public List<Game> getGames() {
		return games;
	}

	public void setGames(List<Game> games) {
		this.games = games;
	}	
	

}
