package com.ynov.games.model;

import java.sql.Time;
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
@Table(name = "games")
public class Game {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_game")
	private Integer id_game;
	
	@Column(name = "code")
	private String code;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "age")
	private Integer age;
	
	@Column(name = "lifetime")
	private Time lifetime;
	
	@Column(name = "price")
	private Integer price;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "nb_gamer")
	private Integer nb_gamer;
	
	//@Column(name = "id_illustrator")
	//private Integer id_illustrator;
	
	@OneToMany(
			cascade = CascadeType.ALL,
			fetch = FetchType.EAGER,
			orphanRemoval = true
			)
	@JoinColumn(name = "id_illustrator")
	
	private List<Illustrator> illustrator = new ArrayList<>();
	
	//@Column(name = "id_creator")
	//private Integer id_creator;
	
	@OneToMany(
			cascade = CascadeType.ALL,
			fetch = FetchType.EAGER,
			orphanRemoval = true
			)
	@JoinColumn(name = "id_creator")
	
	private List<Creator> creator = new ArrayList<>();
	
	
	// Getters and setters	
	

	public Integer getId_game() {
		return id_game;
	}

	public void setId_game(Integer id_game) {
		this.id_game = id_game;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Time getLifetime() {
		return lifetime;
	}

	public void setLifetime(Time lifetime) {
		this.lifetime = lifetime;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getNb_gamer() {
		return nb_gamer;
	}

	public void setNb_gamer(Integer nb_gamer) {
		this.nb_gamer = nb_gamer;
	}

	public List<Illustrator> getIllustrator() {
		return illustrator;
	}

	public void setIllustrator(List<Illustrator> illustrator) {
		this.illustrator = illustrator;
	}

	public List<Creator> getCreator() {
		return creator;
	}

	public void setCreator(List<Creator> creator) {
		this.creator = creator;
	}
			
}
