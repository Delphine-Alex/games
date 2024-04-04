package com.ynov.games.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ynov.games.model.Forum;
import com.ynov.games.repository.ForumRepository;

@Service
public class ForumService {
	
	@Autowired
	private ForumRepository forumRepository;
	
	public Iterable<Forum> getForums(){
		return forumRepository.findAll();
	}
	
	public Optional<Forum> getForum(Integer id) {
		return forumRepository.findById(id);
	}

}
