package com.ynov.games.model;

import java.sql.Time;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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
	
	@ManyToOne
    @JoinColumn(name = "id_illustrator")
    private Illustrator illustrator;
	
	@Column(name = "id_creator")
	private Integer id_creator;
	
	
	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(
	    name = "gamemechanism",
	    joinColumns = { @JoinColumn(name = "id_game") },
	    inverseJoinColumns = { @JoinColumn(name = "id_mechanism") }
	)
	private Set<Mechanism> mechanisms = new HashSet<>();

	
	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(
	    name = "version",
	    joinColumns = { @JoinColumn(name = "id_game") },
	    inverseJoinColumns = { @JoinColumn(name = "id_editor") }
	)
	private Set<Editor> editors = new HashSet<>();
	
	
	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(
	    name = "version",
	    joinColumns = { @JoinColumn(name = "id_game") },
	    inverseJoinColumns = { @JoinColumn(name = "id_langage") }
	)
	private Set<Langage> langages = new HashSet<>();


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


	public Illustrator getIllustrator() {
		return illustrator;
	}


	public void setIllustrator(Illustrator illustrator) {
		this.illustrator = illustrator;
	}


	public Integer getId_creator() {
		return id_creator;
	}


	public void setId_creator(Integer id_creator) {
		this.id_creator = id_creator;
	}


	public Set<Mechanism> getMechanisms() {
		return mechanisms;
	}


	public void setMechanisms(Set<Mechanism> mechanisms) {
		this.mechanisms = mechanisms;
	}


	public Set<Editor> getEditors() {
		return editors;
	}


	public void setEditors(Set<Editor> editors) {
		this.editors = editors;
	}


	public Set<Langage> getLangages() {
		return langages;
	}


	public void setLangages(Set<Langage> langages) {
		this.langages = langages;
	}
	
				
}
