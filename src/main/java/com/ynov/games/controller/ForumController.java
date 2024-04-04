package com.ynov.games.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ynov.games.model.Forum;
import com.ynov.games.service.ForumService;

@RestController
@RequestMapping("/api/v1")
public class ForumController {
	
	@Autowired
	private ForumService forumService;
	
	@GetMapping("/forums")
	public ResponseEntity<Iterable<Forum>> getForums() {
	    Iterable<Forum> forums = forumService.getForums();
	    
	    return ResponseEntity.status(HttpStatus.OK).body(forums);
	}
	
	@GetMapping("/forum/{id}")
	public ResponseEntity<Forum> getForum(@PathVariable("id") Integer id) {
			Optional<Forum> p = forumService.getForum(id);
			if(p.isPresent()) {
				return new ResponseEntity<Forum>(p.get(), HttpStatus.OK);
				
			}
			
			return new ResponseEntity<Forum>(HttpStatus.NOT_FOUND);
	}

}
