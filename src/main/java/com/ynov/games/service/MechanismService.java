package com.ynov.games.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ynov.games.model.Mechanism;
import com.ynov.games.repository.MechanismRepository;

@Service
public class MechanismService {
	
	@Autowired
	private MechanismRepository mechanismRepository;
	
	public Iterable<Mechanism> getMechanisms(){
		return mechanismRepository.findAll();
	}
	
	public Optional<Mechanism> getMechanism(Integer id) {
		return mechanismRepository.findById(id);
	}

}
