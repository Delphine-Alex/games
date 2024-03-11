package com.ynov.games.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ynov.games.model.Mechanism;
import com.ynov.games.service.MechanismService;

@RestController
@RequestMapping("/api/v1")
public class MechanismController {
	
	@Autowired
	private MechanismService mechanismService;
	
	@GetMapping("/mechanisms")
	public ResponseEntity<Iterable<Mechanism>> getMechanisms() {
	    Iterable<Mechanism> mechanisms = mechanismService.getMechanisms();
	    
	    return ResponseEntity.status(HttpStatus.OK).body(mechanisms);
	}
	
	@GetMapping("/mechanism/{id}")
	public ResponseEntity<Mechanism> getMechanism(@PathVariable("id") Integer id) {
			Optional<Mechanism> p = mechanismService.getMechanism(id);
			if(p.isPresent()) {
				return new ResponseEntity<Mechanism>(p.get(), HttpStatus.OK);
				
			}
			
			return new ResponseEntity<Mechanism>(HttpStatus.NOT_FOUND);
	}

}
