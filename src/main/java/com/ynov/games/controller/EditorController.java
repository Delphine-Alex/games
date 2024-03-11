package com.ynov.games.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ynov.games.model.Editor;
import com.ynov.games.service.EditorService;

@RestController
@RequestMapping("/api/v1")
public class EditorController {
	
	@Autowired
	private EditorService editorService;
	
	@GetMapping("/editors")
	public ResponseEntity<Iterable<Editor>> getEditors() {
	    Iterable<Editor> editors = editorService.getEditors();
	    
	    return ResponseEntity.status(HttpStatus.OK).body(editors);
	}
	
	@GetMapping("/editor/{id}")
	public ResponseEntity<Editor> getEditor(@PathVariable("id") Integer id) {
			Optional<Editor> p = editorService.getEditor(id);
			if(p.isPresent()) {
				return new ResponseEntity<Editor>(p.get(), HttpStatus.OK);
				
			}
			
			return new ResponseEntity<Editor>(HttpStatus.NOT_FOUND);
	}
	

}
