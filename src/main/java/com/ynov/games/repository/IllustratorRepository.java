package com.ynov.games.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ynov.games.model.Illustrator;

@Repository
public interface IllustratorRepository extends JpaRepository<Illustrator, Integer> {
	
	Page<Illustrator> findAllByName(Pageable pageable, String name);
	
	Page<Illustrator> findAll(Pageable pageable);

}
