package com.codeup.themolossian.repositories;

import com.codeup.themolossian.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
