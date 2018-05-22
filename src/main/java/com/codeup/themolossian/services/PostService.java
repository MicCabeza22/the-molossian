package com.codeup.themolossian.services;

import com.codeup.themolossian.models.Post;
import com.codeup.themolossian.repositories.PostRepository;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    private PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public void save(Post post) {
        postRepository.save(post);
    }

    public Iterable<Post> findAll() {
        return postRepository.findAll();
    }

    public Post findOne(long id) {
        return postRepository.findOne(id);
    }
}
