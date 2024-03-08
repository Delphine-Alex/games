package com.ynov.games.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ynov.games.model.Illustrator;
import com.ynov.games.repository.IllustratorRepository;

@Service
public class IllustratorService {

	@Autowired
	private IllustratorRepository illustratorRepository;
	
	public Iterable<Illustrator> getIllustrators(){
		return illustratorRepository.findAll();
		
	}
	
}
