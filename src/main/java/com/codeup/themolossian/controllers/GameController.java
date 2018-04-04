package com.codeup.themolossian.controllers;

import com.codeup.themolossian.models.Game;
import com.codeup.themolossian.repositories.GameRepository;
import com.codeup.themolossian.services.GameService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GameController {
	private final GameRepository gameRepository;
    private GameService gameService;

    public GameController(GameRepository gameRepository, GameService gameService) {
        this.gameRepository = gameRepository;
    	this.gameService = gameService;
    }

    @GetMapping("/games")
    public String showAllGames(Model model) {
        Iterable<Game> games = gameService.findAll();

        model.addAttribute("games", games);

        return "games/index";
    }
    
    @GetMapping("/games/add")
    public String showAddGameForm(Model model) {
    	model.addAttribute("game", new Game());
    	
    	return "games/add";
    }
    
    @PostMapping("/games/add")
    public String addNewGame(@ModelAttribute Game game) {
    	gameRepository.save(game);
    	
    	return "redirect:/games";
    }
}
