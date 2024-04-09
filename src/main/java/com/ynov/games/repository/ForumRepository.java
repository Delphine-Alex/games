package com.ynov.games.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ynov.games.model.Forum;

@Repository
public interface ForumRepository extends JpaRepository<Forum, Integer>{
	
	Page<Forum> findAll(Pageable pageable);

}
