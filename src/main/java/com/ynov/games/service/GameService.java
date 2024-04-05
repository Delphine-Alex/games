package com.ynov.games.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ynov.games.model.Game;
import com.ynov.games.repository.GameRepository;

@Service
public class GameService {
	
	@Autowired
	private GameRepository gameRepository;
	
	//public Iterable<Game> getGames(){
	//	return gameRepository.findAll();
	//}
	
//	public Page<Game> getGames(Pageable pageable, String name, Integer age, Integer price) {
//	    return gameRepository.findPaginationGames(pageable, name, age, price) ;
//	}
	
	public Page<Game> getGames(Pageable pageable, String name) {
	    return gameRepository.findAllByName(pageable, name);
	}
	
	public Optional<Game> getGame(Integer id) {
		return gameRepository.findById(id);
	}
	
//	public Iterable<Game> getGamesByAgeGreaterThanEqual(Integer minAge) {
//        return gameRepository.findByAgeGreaterThanEqual(minAge);
//    }
//	
//	public Iterable<Game> getGamesByCreator(String creatorName) {
//        return gameRepository.findByCreatorName(creatorName);
//    }
	
	public Game upsert(Game game) {
		return gameRepository.save(game);
	}
	
	public void deleteGame(Integer id){
		gameRepository.deleteById(id);
	}
	
}
