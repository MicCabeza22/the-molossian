package com.codeup.themolossian.controllers;

import com.codeup.themolossian.models.Game;
import com.codeup.themolossian.services.GameService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GameController {
    private GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/games")
    public String showAllGames(Model model) {
        Iterable<Game> games = gameService.findAll();

        model.addAttribute("games", games);

        return "games/index";
    }
}
