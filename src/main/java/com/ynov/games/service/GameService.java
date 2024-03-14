package com.ynov.games.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ynov.games.model.Game;
import com.ynov.games.repository.GameRepository;

@Service
public class GameService {
	
	@Autowired
	private GameRepository gameRepository;
	
	public Iterable<Game> getGames(){
		return gameRepository.findAll();
	}
	
	public Optional<Game> getGame(Integer id) {
		return gameRepository.findById(id);
	}
	
	public Iterable<Game> getGamesByAgeGreaterThanEqual(Integer minAge) {
        return gameRepository.findByAgeGreaterThanEqual(minAge);
    }
	
	public Iterable<Game> getGamesByCreator(String creatorName) {
        return gameRepository.findByCreatorName(creatorName);
    }
	
	//public Game upsert(Game game) {
	//	return gameRepository.save(game);
	//}
	
	public void deleteGame(Integer id){
		gameRepository.deleteById(id);
	}
	
}
