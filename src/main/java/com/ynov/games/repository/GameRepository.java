package com.ynov.games.repository;


//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ynov.games.model.Game;

@Repository
public interface GameRepository extends CrudRepository<Game, Integer> {
	
//	public Iterable<Game> findByAgeGreaterThanEqual(Integer minAge);
//	
//	@Query("SELECT g FROM Game g JOIN g.creators c WHERE c.name = :creatorName")
//	public Iterable<Game> findByCreatorName(@Param("creatorName") String creatorName);
	

}
