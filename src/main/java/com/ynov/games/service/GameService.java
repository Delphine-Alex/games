package com.ynov.games.service;

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
	

}
