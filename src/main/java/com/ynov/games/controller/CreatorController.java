package com.ynov.games.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ynov.games.model.Creator;
import com.ynov.games.service.CreatorService;

@RestController
public class CreatorController {
	
	@Autowired
	private CreatorService creatorService;
	
	@GetMapping("/creators")
	public Iterable<Creator> getCreators(){
		return creatorService.getCreators();
	}

}
