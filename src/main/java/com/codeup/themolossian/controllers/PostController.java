package com.codeup.themolossian.controllers;

import com.codeup.themolossian.models.Post;
import com.codeup.themolossian.services.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
    
    @GetMapping("/posts/create")
    public String showCreatePostForm(Model model) {
    	model.addAttribute("post", new Post());
    	
    	return "posts/create";
    }
    
    @GetMapping("/posts/{id}/edit")
    public String showEditPostForm(@PathVariable long id, Model model) {
    	Post post = postService.findOne(id);
    	
    	model.addAttribute("post", post);
    	
    	return "posts/edit";
    }
}
