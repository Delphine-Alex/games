package com.ynov.games.listener;

import org.springframework.stereotype.Component;

import com.ynov.games.model.Game;

@Component
public class GameEventListener {

	public void handleGameEvent(Game game) {
        System.out.println("Nouveau jeu ajouté : " + game.getName());
    }

}
