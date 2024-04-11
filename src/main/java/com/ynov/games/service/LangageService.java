package com.ynov.games.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ynov.games.model.Langage;
import com.ynov.games.repository.LangageRepository;

@Service
public class LangageService {
	
	@Autowired
	private LangageRepository langageRepository;
	
	public Page<Langage> getLangages(Pageable pageable) {
        return langageRepository.findAll(pageable);
    }
	
	public Optional<Langage> getLangage(Integer id) {
		return langageRepository.findById(id);
	}
	
	public Langage upsertLangage(Langage langage) {
		return langageRepository.save(langage);
	}
	
	public void deleteLangage(Integer id){
		langageRepository.deleteById(id);
	}

}
