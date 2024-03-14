package com.ynov.games.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ynov.games.model.Tournament;
import com.ynov.games.service.TournamentService;

@RestController
@RequestMapping("/api/v1")
public class TournamentController {
	
	@Autowired
	private TournamentService tournamentService;
	
	@GetMapping("/tournaments")
	public ResponseEntity<Iterable<Tournament>> getTournaments() {
	    Iterable<Tournament> tournaments = tournamentService.getTournaments();
	    
	    return ResponseEntity.status(HttpStatus.OK).body(tournaments);
	}
	
	@GetMapping("/tournament/{id}")
	public ResponseEntity<Tournament> getTournament(@PathVariable("id") Integer id) {
			Optional<Tournament> p = tournamentService.getTournament(id);
			if(p.isPresent()) {
				return new ResponseEntity<Tournament>(p.get(), HttpStatus.OK);
				
			}
			
			return new ResponseEntity<Tournament>(HttpStatus.NOT_FOUND);
	}

}
