package com.ynov.games.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ynov.games.model.Mechanism;

@Repository
public interface MechanismRepository extends CrudRepository<Mechanism, Integer> {

	Page<Mechanism> findAll(Pageable pageable);
}
