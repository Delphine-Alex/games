package com.ynov.games.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ynov.games.model.Creator;
import com.ynov.games.repository.CreatorRepository;

@Service
public class CreatorService {
	
	@Autowired
	private CreatorRepository creatorRepository;
	
	public Page<Creator> getCreators(Pageable pageable, String name) {
        if (name != null) {
            return creatorRepository.findAllByName(pageable, name);
        } else {
            return creatorRepository.findAll(pageable);
        }
    }
	
	public Optional<Creator> getCreator(Integer id) {
		return creatorRepository.findById(id);
	}
	
	public Creator upsert(Creator creator) {
		return creatorRepository.save(creator);
	}
	
	public void deleteCreator(Integer id){
		creatorRepository.deleteById(id);
	}

}
