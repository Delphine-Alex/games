package com.ynov.games.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "forums")
public class Forum {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_forum")
	private Integer id_forum;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "id_langage")
	private Integer id_langage;
	
	
	// Getters and setters	


	public Integer getId_forum() {
		return id_forum;
	}


	public void setId_forum(Integer id_forum) {
		this.id_forum = id_forum;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Integer getId_langage() {
		return id_langage;
	}


	public void setId_langage(Integer id_langage) {
		this.id_langage = id_langage;
	}
		
	
}
