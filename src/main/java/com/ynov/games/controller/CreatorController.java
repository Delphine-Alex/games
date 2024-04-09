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

import com.ynov.games.model.Creator;
import com.ynov.games.service.CreatorService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1")
@Tag(name = "Creator", description = "Creator Controller APIs")
public class CreatorController {
	
	@Autowired
	private CreatorService creatorService;
	
	@GetMapping("/creators")
	public ResponseEntity<Page<Creator>> getCreators(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int pageSize,
            @RequestParam(required = false) String name
    ) {
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<Creator> creatorsPage = creatorService.getCreators(pageable, name);
        
        if (creatorsPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(creatorsPage, HttpStatus.OK);
        }
    }

	@GetMapping("/creator/{id}")
	public ResponseEntity<Creator> getCreator(@PathVariable("id") Integer id) {
			Optional<Creator> p = creatorService.getCreator(id);
			if(p.isPresent()) {
				return new ResponseEntity<Creator>(p.get(), HttpStatus.OK);
				
			}
			
			return new ResponseEntity<Creator>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/creators")
	public ResponseEntity<Creator> createCreator(@RequestBody Creator creator) {
		Creator createCreator = creatorService.upsert(creator);
	    return ResponseEntity.status(HttpStatus.CREATED).body(createCreator);
	}
	
	@PutMapping("/creator/{id}")
	public ResponseEntity<Creator> updateCreator(@PathVariable("id") Integer id, @RequestBody Creator creator) {
		
	    Optional<Creator> existingCreator = creatorService.getCreator(id);
	    if (existingCreator.isEmpty()) {
	        return ResponseEntity.notFound().build();
	    }
	    
	    creator.setId_creator(id);
	    Creator updateCreator = creatorService.upsert(creator);
	    
	    return ResponseEntity.status(HttpStatus.OK).body(updateCreator);
	}
	
	@DeleteMapping("/creator/{id}")
	public ResponseEntity<Creator> deleteCreator(@PathVariable("id") Integer id) {
	    creatorService.deleteCreator(id);
	    
	    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
