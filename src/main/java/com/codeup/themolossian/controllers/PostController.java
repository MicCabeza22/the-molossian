package com.codeup.themolossian.controllers;

import com.codeup.themolossian.models.Post;
import com.codeup.themolossian.repositories.PostRepository;
import com.codeup.themolossian.services.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PostController {
	private final PostRepository postRepository;
    private PostService postService;

    public PostController(PostRepository postRepository, PostService postService) {
    	this.postRepository = postRepository;
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
    
    @PostMapping("/posts/create")
    public String createNewPost(Post post) {
    	postRepository.save(post);
    	
    	return "redirect:/posts";
    }
    
    @GetMapping("/posts/{id}/edit")
    public String showEditPostForm(@PathVariable long id, Model model) {
    	Post post = postService.findOne(id);
    	
    	model.addAttribute("post", post);
    	
    	return "posts/edit";
    }
    
    @PostMapping("/posts/{id}/delete")
    public String deletePost(@PathVariable long id) {
		postService.delete(id);
    	
    	return "redirect:/posts";
    }
}
