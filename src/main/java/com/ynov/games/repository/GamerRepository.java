package com.ynov.games.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ynov.games.model.Gamer;

@Repository
public interface GamerRepository extends CrudRepository<Gamer, Integer>{

}
