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

import com.ynov.games.model.Illustrator;
import com.ynov.games.service.IllustratorService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1")
@Tag(name = "Illustrator", description = "Illustrator Controller APIs")
public class IllustratorController {
	
	@Autowired
	private IllustratorService illustratorService;
	
	@GetMapping("/illustrators")
	public ResponseEntity<Page<Illustrator>> getIllustrators(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int pageSize,
            @RequestParam(required = false) String name
    ) {
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<Illustrator> illustratorsPage = illustratorService.getIllustrators(pageable, name);
        
        if (illustratorsPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(illustratorsPage, HttpStatus.OK);
        }
    }
	
	@GetMapping("/illustrator/{id}")
	public ResponseEntity<Illustrator> getIllustrator(@PathVariable("id") Integer id) {
			Optional<Illustrator> p = illustratorService.getIllustrator(id);
			if(p.isPresent()) {
				return new ResponseEntity<Illustrator>(p.get(), HttpStatus.OK);
				
			}
			
			return new ResponseEntity<Illustrator>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/illustrators")
	public ResponseEntity<Illustrator> createIllustrator(@RequestBody Illustrator illustrator) {
		Illustrator createIllustrator = illustratorService.upsert(illustrator);
	    return ResponseEntity.status(HttpStatus.CREATED).body(createIllustrator);
	}
	
	@PutMapping("/illustrator/{id}")
	public ResponseEntity<Illustrator> updateIllustrator(@PathVariable("id") Integer id, @RequestBody Illustrator illustrator) {
		
	    Optional<Illustrator> existingIllustrator = illustratorService.getIllustrator(id);
	    if (existingIllustrator.isEmpty()) {
	        return ResponseEntity.notFound().build();
	    }
	    
	    illustrator.setId_illustrator(id);
	    Illustrator updateIllustrator = illustratorService.upsert(illustrator);
	    
	    return ResponseEntity.status(HttpStatus.OK).body(updateIllustrator);
	}
	
	@DeleteMapping("/illustrator/{id}")
	public ResponseEntity<Illustrator> delateIllustrator(@PathVariable("id") Integer id) {
	    illustratorService.deleteIllustrator(id);
	    
	    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	

}
