package com.codeup.themolossian.controllers;

import com.codeup.themolossian.models.User;
import com.codeup.themolossian.repositories.UserRepository;
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
    private PasswordEncoder passwordEncoder;

    public UserController(UserRepository userRepository, UserService userService, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userService = userService;
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

    @GetMapping("/users/profile/{id}")
    public String showProfilePage(@PathVariable long id, Model model) {
        User user = userRepository.findOne(id);

        model.addAttribute("user", user);

        return "users/profile";
    }
}
