package com.codeup.themolossian.controllers;

import com.codeup.themolossian.models.Event;
import com.codeup.themolossian.models.Game;
import com.codeup.themolossian.models.User;
import com.codeup.themolossian.repositories.UserRepository;
import com.codeup.themolossian.services.EventService;
import com.codeup.themolossian.services.GameService;
import com.codeup.themolossian.services.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    private final UserRepository userRepository;
    private UserService userService;
    private EventService eventService;
    private GameService gameService;
    private PasswordEncoder passwordEncoder;

    public UserController(UserRepository userRepository, UserService userService, EventService eventService,
                          GameService gameService, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userService = userService;
        this.eventService = eventService;
        this.gameService = gameService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new User());

        return "register";
    }

    @PostMapping("/register")
    public String registerNewAccount(@ModelAttribute User user) {
        String hash = passwordEncoder.encode(user.getPassword());

        user.setPassword(hash);
        userRepository.save(user);

        return "redirect:/login";
    }

    @GetMapping("/users")
    public String showAllUsers(Model model) {
        Iterable<User> users = userService.findAll();

        model.addAttribute("users", users);

        return "users/index";
    }

    @GetMapping("/users/{id}")
    public String showProfilePage(@PathVariable long id, Model model) {
        User user = userService.findOne(id);
        Iterable<Game> games = gameService.findAll();

        model.addAttribute("user", user);
        model.addAttribute("games", games);

        return "users/profile";
    }

    @GetMapping("/users/{id}/edit")
    public String showEditProfilePage(@PathVariable long id, Model model) {
        User user = userService.findOne(id);

        model.addAttribute("user", user);

        return "users/edit";
    }

    @PostMapping("/users/{id}/edit")
    public String editProfile(@PathVariable long id, @ModelAttribute User user) {
        String hash = passwordEncoder.encode(user.getPassword());

        user.setPassword(hash);
        user.setId(id);
        userService.save(user);

        return "redirect:/users/" + id;
    }

    @GetMapping("/users/events")
    public String showAllEvents(Model model) {
        Iterable<Event> events = eventService.findAll();

        model.addAttribute("events", events);

        return "users/events";
    }
}
