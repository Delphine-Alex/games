package com.ynov.games.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ynov.games.model.Editor;
import com.ynov.games.repository.EditorRepository;

@Service
public class EditorService {
	
	@Autowired
	private EditorRepository editorRepository;
	
	public Page<Editor> getEditors(Pageable pageable) {
        return editorRepository.findAll(pageable);
    }
	
	public Optional<Editor> getEditor(Integer id) {
		return editorRepository.findById(id);
	}
	
	public Editor upsertEditor(Editor editor) {
		return editorRepository.save(editor);
	}
	
	public void deleteEditor(Integer id){
		editorRepository.deleteById(id);
	}

}
