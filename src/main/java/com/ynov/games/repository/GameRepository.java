package com.ynov.games.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ynov.games.model.Game;

@Repository
public interface GameRepository extends CrudRepository<Game, Integer> {

}