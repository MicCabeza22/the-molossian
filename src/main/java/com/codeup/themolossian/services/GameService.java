package com.codeup.themolossian.services;

import com.codeup.themolossian.models.Game;
import com.codeup.themolossian.repositories.GameRepository;
import org.springframework.stereotype.Service;

@Service
public class GameService {
    private GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public void save(Game game) {
        gameRepository.save(game);
    }

    public Iterable<Game> findAll() {
        return gameRepository.findAll();
    }
}
