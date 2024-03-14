package com.ynov.games.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ynov.games.model.Tournament;
import com.ynov.games.repository.TournamentRepository;

@Service
public class TournamentService {

	@Autowired
	private TournamentRepository tournamentRepository;
	
	public Iterable<Tournament> getTournaments(){
		return tournamentRepository.findAll();
	}
	
	public Optional<Tournament> getTournament(Integer id) {
		return tournamentRepository.findById(id);
	}
}
