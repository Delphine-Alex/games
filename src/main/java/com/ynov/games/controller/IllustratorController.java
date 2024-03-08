package com.ynov.games.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ynov.games.model.Illustrator;
import com.ynov.games.service.IllustratorService;

@RestController
public class IllustratorController {
	
	@Autowired
	private IllustratorService illustratorService;
	
	@GetMapping("/illustrators")
	public Iterable<Illustrator> getIllustrators(){
		return illustratorService.getIllustrators();
	}
	
	

}
