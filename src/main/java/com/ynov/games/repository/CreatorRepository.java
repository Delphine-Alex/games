package com.ynov.games.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ynov.games.model.Creator;

@Repository
public interface CreatorRepository extends CrudRepository<Creator, Integer>{

}
