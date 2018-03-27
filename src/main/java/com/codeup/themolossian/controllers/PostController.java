package com.codeup.themolossian.controllers;

import com.codeup.themolossian.models.Post;
import com.codeup.themolossian.services.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PostController {
    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/posts")
    public String showAllPosts(Model model) {
        Iterable<Post> posts = postService.findAll();

        model.addAttribute("posts", posts);

        return "posts/index";
    }
}
