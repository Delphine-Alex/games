package com.ynov.games.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ynov.games.model.Tournament;

@Repository
public interface TournamentRepository extends CrudRepository<Tournament, Integer> {

}
