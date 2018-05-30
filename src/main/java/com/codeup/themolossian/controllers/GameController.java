package com.codeup.themolossian.controllers;

import com.codeup.themolossian.models.EsrbRating;
import com.codeup.themolossian.models.Game;
import com.codeup.themolossian.models.Genre;
import com.codeup.themolossian.repositories.EsrbRatingRepository;
import com.codeup.themolossian.repositories.GameRepository;
import com.codeup.themolossian.repositories.GenreRepository;
import com.codeup.themolossian.services.GameService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GameController {
	private final EsrbRatingRepository esrbRatingRepository;
	private final GenreRepository genreRepository;
	private final GameRepository gameRepository;
    private GameService gameService;

    public GameController(EsrbRatingRepository esrbRatingRepository,
    		GenreRepository genreRepository,
    		GameRepository gameRepository,
    		GameService gameService) {
    	this.esrbRatingRepository = esrbRatingRepository;
    	this.genreRepository = genreRepository;
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
       	Iterable<EsrbRating> esrbRatings = esrbRatingRepository.findAll();
       	Iterable<Genre> genres = genreRepository.findAll();
    	
    	model.addAttribute("esrbRatings", esrbRatings);
    	model.addAttribute("genre", genres);
    	model.addAttribute("game", new Game());
    	
    	return "games/add";
    }
    
    @PostMapping("/games/add")
    public String addNewGame(@ModelAttribute Game game) {
    	gameRepository.save(game);
    	
    	return "redirect:/games";
    }
}
