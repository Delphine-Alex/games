package com.ynov.games.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ynov.games.model.Creator;
import com.ynov.games.service.CreatorService;

@RestController
@RequestMapping("/api/v1")
public class CreatorController {
	
	@Autowired
	private CreatorService creatorService;
	
	@GetMapping("/creators")
	public Iterable<Creator> getCreators(){
		return creatorService.getCreators();
	}

	@GetMapping("/creator/{id}")
	public ResponseEntity<Creator> getCreator(@PathVariable("id") Integer id) {
			Optional<Creator> p = creatorService.getCreator(id);
			if(p.isPresent()) {
				return new ResponseEntity<Creator>(p.get(), HttpStatus.OK);
				
			}
			
			return new ResponseEntity<Creator>(HttpStatus.NOT_FOUND);
	}

}
