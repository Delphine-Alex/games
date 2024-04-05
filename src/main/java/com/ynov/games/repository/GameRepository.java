package com.ynov.games.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ynov.games.model.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, Integer> {
	
//	public Iterable<Game> findByAgeGreaterThanEqual(Integer minAge);
//	
//	@Query("SELECT g FROM Game g JOIN g.creators c WHERE c.name = :creatorName")
//	public Iterable<Game> findByCreatorName(@Param("creatorName") String creatorName);
	
	Page<Game> findAllByName(Pageable pageable, String name);
	
	Page<Game> findAll(Pageable pageable);

}
