package com.codeup.themolossian.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    @GetMapping("/register")
    public String showRegisterForm() {
        return "register";
    }
}
