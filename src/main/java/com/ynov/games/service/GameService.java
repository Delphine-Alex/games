package com.ynov.games.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ynov.games.model.Game;
import com.ynov.games.repository.GameRepository;

@Service
public class GameService {
	
	@Autowired
	private GameRepository gameRepository;
	
	public Page<Game> getGames(Pageable pageable, String name, Integer minAge, String illustratorName, String creatorName, Integer minPrice, Integer maxPrice, List<Integer> nbGamerList) {
		
		if (name != null && minAge != null && illustratorName != null && creatorName != null && minPrice != null && maxPrice != null) {
            return gameRepository.findAllByNameAndAgeGreaterThanEqualAndIllustratorNameAndCreatorNameAndPriceBetween(pageable, name, minAge, illustratorName, creatorName, minPrice, maxPrice);
        } else if (illustratorName != null) {
        	return gameRepository.findAllByIllustratorName(pageable, illustratorName);
        } else if (minPrice != null && maxPrice != null) {
            return gameRepository.findAllByPriceBetween(pageable, minPrice, maxPrice);
        } else if (minAge != null) {
        	return gameRepository.findAllByAgeGreaterThanEqual(pageable, minAge);
        } else if (nbGamerList != null) {
        	return gameRepository.findAllByNbGamerIn(pageable, nbGamerList);
        } else if (creatorName != null) {
        	return gameRepository.findAllByCreatorName(pageable, creatorName);
        } else if (name != null) {
            return gameRepository.findAllByName(pageable, name);
        } else {
            return gameRepository.findAll(pageable);
        }
    }
	
	public Optional<Game> getGame(Integer id) {
		return gameRepository.findById(id);
	}
	
	public Game upsert(Game game) {
		return gameRepository.save(game);
    }
	
	public void deleteGame(Integer id){
		gameRepository.deleteById(id);
	}
	
}
