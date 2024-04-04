package com.ynov.games.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ynov.games.model.Forum;

@Repository
public interface ForumRepository  extends CrudRepository<Forum, Integer>{

}
