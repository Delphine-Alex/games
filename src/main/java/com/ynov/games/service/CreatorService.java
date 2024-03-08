package com.ynov.games.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ynov.games.model.Creator;
import com.ynov.games.repository.CreatorRepository;

@Service
public class CreatorService {
	
	@Autowired
	private CreatorRepository creatorRepository;
	
	public Iterable<Creator> getCreators(){
		return creatorRepository.findAll();
	}
	
	public Optional<Creator> getCreator(Integer id) {
		return creatorRepository.findById(id);
	}

}
