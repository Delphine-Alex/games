package com.ynov.games.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ynov.games.model.Langage;

@Repository
public interface LangageRepository extends CrudRepository<Langage, Integer> {

	Page<Langage> findAll(Pageable pageable);
}
