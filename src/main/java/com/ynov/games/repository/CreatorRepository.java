package com.ynov.games.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ynov.games.model.Creator;

@Repository
public interface CreatorRepository extends JpaRepository<Creator, Integer>{
	
	Page<Creator> findAllByName(Pageable pageable, String name);
	
	Page<Creator> findAll(Pageable pageable);

}
