package com.ynov.games.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ynov.games.model.Editor;

@Repository
public interface EditorRepository extends CrudRepository<Editor, Integer> {

}
