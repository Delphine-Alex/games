package com.ynov.games.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ynov.games.model.Mechanism;
import com.ynov.games.service.MechanismService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1")
@Tag(name = "Mechanism", description = "Mechanism Controller APIs")
public class MechanismController {
	
	@Autowired
	private MechanismService mechanismService;
	
	@GetMapping("/mechanisms")
	public ResponseEntity<Page<Mechanism>> getMechanisms(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int pageSize
    ) {
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<Mechanism> mechanismsPage = mechanismService.getMechanisms(pageable);
        
        if (mechanismsPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(mechanismsPage, HttpStatus.OK);
        }
    }
	
	@GetMapping("/mechanism/{id}")
	public ResponseEntity<Mechanism> getMechanism(@PathVariable("id") Integer id) {
			Optional<Mechanism> p = mechanismService.getMechanism(id);
			if(p.isPresent()) {
				return new ResponseEntity<Mechanism>(p.get(), HttpStatus.OK);
				
			}
			
			return new ResponseEntity<Mechanism>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/mechanisms")
	public ResponseEntity<Mechanism> createMechanism(@RequestBody Mechanism mechanism) {
		Mechanism createMechanism = mechanismService.upsertMechanism(mechanism);
	    return ResponseEntity.status(HttpStatus.CREATED).body(createMechanism);
	}
	
	@PutMapping("/mechanism/{id}")
	public ResponseEntity<Mechanism> updateMechanism(@PathVariable("id") Integer id, @RequestBody Mechanism mechanism) {
		
	    Optional<Mechanism> existingMechanism = mechanismService.getMechanism(id);
	    if (existingMechanism.isEmpty()) {
	        return ResponseEntity.notFound().build();
	    }
	    
	    mechanism.setId_mechanism(id);
	    Mechanism updateMechanism = mechanismService.upsertMechanism(mechanism);
	    
	    return ResponseEntity.status(HttpStatus.OK).body(updateMechanism);
	}
	
	@DeleteMapping("/mechanism/{id}")
	public ResponseEntity<Mechanism> deleteMechanism(@PathVariable("id") Integer id) {
		mechanismService.deleteMechanism(id);
	    
	    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
