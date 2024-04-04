package com.ynov.games.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ynov.games.model.Game;
import com.ynov.games.service.GameService;

@RestController
@RequestMapping("/api/v1")
public class GameController {
	
	@Autowired
	private GameService gameService;
	
	@GetMapping("/games")
//	public ResponseEntity<Iterable<Game>> getGames(@RequestParam(required = false) Integer min_age, @RequestParam(required = false) String creator) {
//		Iterable<Game> games;
//		if (creator != null) {
//            games = gameService.getGamesByCreator(creator);
//        } else if (min_age != null) {
//            games = gameService.getGamesByAgeGreaterThanEqual(min_age);
//        } else {
//            games = gameService.getGames();
//        }
//        return ResponseEntity.status(HttpStatus.OK).body(games);
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
	
	
	@PostMapping("/games")
	public ResponseEntity<Game> createGame(@RequestBody Game game) {
		Game createGame = gameService.upsert(game);
	    return ResponseEntity.status(HttpStatus.CREATED).body(createGame);
	}

	
	@PutMapping("/game/{id}")
	public ResponseEntity<Game> updateGame(@PathVariable("id") Integer id, @RequestBody Game game) {
		
	    Optional<Game> existingGame = gameService.getGame(id);
	    if (existingGame.isEmpty()) {
	        return ResponseEntity.notFound().build();
	    }
	    
	    game.setId_game(id);
	    Game updatedGame = gameService.upsert(game);
	    
	    return ResponseEntity.status(HttpStatus.OK).body(updatedGame);
	}
	
	@DeleteMapping("/game/{id}")
	public ResponseEntity<Game> delateGame(@PathVariable("id") Integer id) {
	    gameService.deleteGame(id);
	    
	    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	
}
