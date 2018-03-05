package com.codeup.themolossian.repositories;

import com.codeup.themolossian.models.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {
}
