package com.ynov.games.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ynov.games.model.Editor;
import com.ynov.games.repository.EditorRepository;

@Service
public class EditorService {
	
	@Autowired
	private EditorRepository editorRepository;
	
	public Iterable<Editor> getEditors(){
		return editorRepository.findAll();
	}
	
	public Optional<Editor> getEditor(Integer id) {
		return editorRepository.findById(id);
	}

}
