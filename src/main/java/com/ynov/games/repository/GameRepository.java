package com.ynov.games.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ynov.games.model.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, Integer> {
	
	Page<Game> findAll(Pageable pageable);
	
	Page<Game> findAllByName(Pageable pageable, String name);
	
	Page<Game> findAllByCreatorName(Pageable pageable, String creatorName);
	
    Page<Game> findAllByNbGamerIn(Pageable pageable, List<Integer> nbGamerList);
	
	Page<Game> findAllByAgeGreaterThanEqual(Pageable pageable, int minAge);
	
	Page<Game> findAllByIllustratorName(Pageable pageable, String illustratorName);
	
	Page<Game> findAllByPriceBetween(Pageable pageable, Integer minPrice, Integer maxPrice);

    Page<Game> findAllByNameAndAgeGreaterThanEqualAndIllustratorNameAndCreatorNameAndPriceBetween(Pageable pageable, String name, int minAge, String illustratorName, String creatorName, Integer minPrice, Integer maxPrice);



}
