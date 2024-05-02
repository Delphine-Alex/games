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

import com.ynov.games.model.Forum;
import com.ynov.games.service.ForumService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1")
@Tag(name = "Forum", description = "Forum Controller APIs")
public class ForumController {
	
	@Autowired
	private ForumService forumService;
	
	@GetMapping("/forums")
	public ResponseEntity<Page<Forum>> getForums(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int pageSize
    ) {
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<Forum> forumsPage = forumService.getForums(pageable, null);
        
        if (forumsPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(forumsPage, HttpStatus.OK);
        }
    }
	
	@GetMapping("/forum/{id}")
	public ResponseEntity<Forum> getForum(@PathVariable("id") Integer id) {
			Optional<Forum> p = forumService.getForum(id);
			if(p.isPresent()) {
				return new ResponseEntity<Forum>(p.get(), HttpStatus.OK);
				
			}
			
			return new ResponseEntity<Forum>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/forums")
	public ResponseEntity<Forum> createForum(@RequestBody Forum forum) {
		Forum createForum = forumService.upsert(forum);
	    return ResponseEntity.status(HttpStatus.CREATED).body(createForum);
	}
	
	@PutMapping("/forum/{id}")
	public ResponseEntity<Forum> updateForum(@PathVariable("id") Integer id, @RequestBody Forum forum) {
		
	    Optional<Forum> existingForum = forumService.getForum(id);
	    if (existingForum.isEmpty()) {
	        return ResponseEntity.notFound().build();
	    }
	    
	    forum.setId_forum(id);
	    Forum updateForum = forumService.upsert(forum);
	    
	    return ResponseEntity.status(HttpStatus.OK).body(updateForum);
	}
	
	@DeleteMapping("/forum/{id}")
	public ResponseEntity<Forum> deleteCreator(@PathVariable("id") Integer id) {
	    forumService.deleteForum(id);
	    
	    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
