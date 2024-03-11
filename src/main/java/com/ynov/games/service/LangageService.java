package com.ynov.games.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ynov.games.model.Langage;
import com.ynov.games.repository.LangageRepository;

@Service
public class LangageService {
	
	@Autowired
	private LangageRepository langageRepository;
	
	public Iterable<Langage> getLangages(){
		return langageRepository.findAll();
	}
	
	public Optional<Langage> getLangage(Integer id) {
		return langageRepository.findById(id);
	}

}
