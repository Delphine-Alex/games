package com.ynov.games.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ynov.games.model.Mechanism;
import com.ynov.games.repository.MechanismRepository;

@Service
public class MechanismService {
	
	@Autowired
	private MechanismRepository mechanismRepository;
	
	public Page<Mechanism> getMechanisms(Pageable pageable) {
        return mechanismRepository.findAll(pageable);
    }
	
	public Optional<Mechanism> getMechanism(Integer id) {
		return mechanismRepository.findById(id);
	}
	
	public Mechanism upsertMechanism(Mechanism mechanism) {
		return mechanismRepository.save(mechanism);
	}
	
	public void deleteMechanism(Integer id){
		mechanismRepository.deleteById(id);
	}

}
