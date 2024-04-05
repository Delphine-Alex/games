package com.ynov.games.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ynov.games.model.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, Integer> {
	
	Page<Game> findAllByName(Pageable pageable, String name);
	
	Page<Game> findAll(Pageable pageable);

}
