package com.ynov.games.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ynov.games.model.Forum;
import com.ynov.games.repository.ForumRepository;

@Service
public class ForumService {
	
	@Autowired
	private ForumRepository forumRepository;
	
	public Page<Forum> getForums(Pageable pageable, String name) {
        return forumRepository.findAll(pageable);
    }
	
	public Optional<Forum> getForum(Integer id) {
		return forumRepository.findById(id);
	}

	public Forum upsert(Forum forum) {
		return forumRepository.save(forum);
	}
	
	public void deleteForum(Integer id){
		forumRepository.deleteById(id);
	}
}
