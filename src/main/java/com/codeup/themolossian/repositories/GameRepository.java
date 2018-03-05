package com.codeup.themolossian.repositories;

import com.codeup.themolossian.models.Game;
import org.springframework.data.repository.CrudRepository;

public interface GameRepository extends CrudRepository<Game, Long> {
}
