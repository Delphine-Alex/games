package com.ynov.games.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ynov.games.model.Illustrator;

@Repository
public interface IllustratorRepository extends CrudRepository<Illustrator, Integer> {

}
