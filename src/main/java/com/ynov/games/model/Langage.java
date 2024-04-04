package com.ynov.games.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
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
	
	@OneToMany(
			cascade = CascadeType.ALL,
			fetch = FetchType.EAGER,
			orphanRemoval = true
			)
	@JoinColumn(name = "id_langage")
	
	private List<Forum> forums = new ArrayList<>();
	
	@OneToMany(
			cascade = CascadeType.ALL,
			fetch = FetchType.EAGER,
			orphanRemoval = true
			)
	@JoinColumn(name = "id_langage")
	
	private List<Gamer> gamers = new ArrayList<>();
	
	@OneToMany(
			cascade = CascadeType.ALL,
			fetch = FetchType.EAGER,
			orphanRemoval = true
			)
	@JoinColumn(name = "id_langage")
	
	private List<Tournament> tournaments = new ArrayList<>();
	
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

	public List<Forum> getForums() {
		return forums;
	}

	public void setForums(List<Forum> forums) {
		this.forums = forums;
	}

	public List<Gamer> getGamers() {
		return gamers;
	}

	public void setGamers(List<Gamer> gamers) {
		this.gamers = gamers;
	}

	public List<Tournament> getTournaments() {
		return tournaments;
	}

	public void setTournaments(List<Tournament> tournaments) {
		this.tournaments = tournaments;
	}

	public Set<Game> getGames() {
		return games;
	}

	public void setGames(Set<Game> games) {
		this.games = games;
	}
	
	

}
