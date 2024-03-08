package com.ynov.games.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping("/illustrator/{id}")
	public ResponseEntity<Illustrator> getIllustrator(@PathVariable("id") Integer id) {
			Optional<Illustrator> p = illustratorService.getIllustrator(id);
			if(p.isPresent()) {
				return new ResponseEntity<Illustrator>(p.get(), HttpStatus.OK);
				
			}
			
			return new ResponseEntity<Illustrator>(HttpStatus.NOT_FOUND);
	}
	
	

}
