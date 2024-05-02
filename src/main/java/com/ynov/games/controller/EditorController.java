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

import com.ynov.games.model.Editor;
import com.ynov.games.service.EditorService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1")
@Tag(name = "Editor", description = "Editor Controller APIs")
public class EditorController {
	
	@Autowired
	private EditorService editorService;
	
	@GetMapping("/editors")
	public ResponseEntity<Page<Editor>> getEditors(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int pageSize
    ) {
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<Editor> editorsPage = editorService.getEditors(pageable);
        
        if (editorsPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(editorsPage, HttpStatus.OK);
        }
    }
	
	@GetMapping("/editor/{id}")
	public ResponseEntity<Editor> getEditor(@PathVariable("id") Integer id) {
			Optional<Editor> p = editorService.getEditor(id);
			if(p.isPresent()) {
				return new ResponseEntity<Editor>(p.get(), HttpStatus.OK);
				
			}
			
			return new ResponseEntity<Editor>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/editors")
	public ResponseEntity<Editor> createEditor(@RequestBody Editor editor) {
		Editor createEditor = editorService.upsertEditor(editor);
	    return ResponseEntity.status(HttpStatus.CREATED).body(createEditor);
	}
	
	@PutMapping("/editor/{id}")
	public ResponseEntity<Editor> updateEditor(@PathVariable("id") Integer id, @RequestBody Editor editor) {
		
	    Optional<Editor> existingEditor = editorService.getEditor(id);
	    if (existingEditor.isEmpty()) {
	        return ResponseEntity.notFound().build();
	    }
	    
	    editor.setId_editor(id);
	    Editor updateEditor = editorService.upsertEditor(editor);
	    
	    return ResponseEntity.status(HttpStatus.OK).body(updateEditor);
	}
	
	@DeleteMapping("/editor/{id}")
	public ResponseEntity<Editor> deleteEditor(@PathVariable("id") Integer id) {
		editorService.deleteEditor(id);
	    
	    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	

}
