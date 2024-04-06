package com.ynov.games.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ynov.games.model.Game;
import com.ynov.games.service.GameService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1")
@Tag(name = "Game", description = "Game Controller APIs")
public class GameController {
	
	@Autowired
	private GameService gameService;
	
	@GetMapping("/games")
    public ResponseEntity<Page<Game>> getGames(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int pageSize,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Integer minAge,
            @RequestParam(required = false) String illustratorName,
            @RequestParam(required = false) String creatorName,
            @RequestParam(required = false) Integer minPrice,
            @RequestParam(required = false) Integer maxPrice,
            @RequestParam(required = false) List<Integer> nbGamerList
            
    ) {
		
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<Game> gamesPage = gameService.getGames(pageable, name, minAge, illustratorName, creatorName, minPrice, maxPrice, nbGamerList);
        
        if (gamesPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(gamesPage, HttpStatus.OK);
        }
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
	    Game updateGame = gameService.upsert(game);
	    
	    return ResponseEntity.status(HttpStatus.OK).body(updateGame);
	}
	
	@DeleteMapping("/game/{id}")
	public ResponseEntity<Game> delateGame(@PathVariable("id") Integer id) {
	    gameService.deleteGame(id);
	    
	    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	
}
