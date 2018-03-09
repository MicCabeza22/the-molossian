package com.codeup.themolossian.repositories;

import com.codeup.themolossian.models.Event;
import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<Event, Long> {
}
