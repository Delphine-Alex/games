package com.ynov.games.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ynov.games.model.Game;
import com.ynov.games.service.GameService;

@RestController
public class GameController {
	
	@Autowired
	private GameService gameService;
	
	@GetMapping("/games")
	public Iterable<Game> getGames(){
		return gameService.getGames();
	}
	
	@GetMapping("/game/{id}")
	public ResponseEntity<Game> getGame(@PathVariable("id") Integer id) {
			Optional<Game> p = gameService.getGame(id);
			if(p.isPresent()) {
				return new ResponseEntity<Game>(p.get(), HttpStatus.OK);
				
			}
			
			return new ResponseEntity<Game>(HttpStatus.NOT_FOUND);
	}
}
