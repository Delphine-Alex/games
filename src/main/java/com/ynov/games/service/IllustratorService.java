package com.ynov.games.service;

import java.util.Optional;

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
	
	public Optional<Illustrator> getIllustrator(Integer id) {
		return illustratorRepository.findById(id);
	}
	
	public Illustrator upsert(Illustrator illustrator) {
		return illustratorRepository.save(illustrator);
	}
	
	public void deleteIllustrator(Integer id){
		illustratorRepository.deleteById(id);
	}
	
}
