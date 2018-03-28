package com.codeup.themolossian.services;

import com.codeup.themolossian.models.Event;
import com.codeup.themolossian.repositories.EventRepository;
import org.springframework.stereotype.Service;

@Service
public class EventService {
    private EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public void save(Event event) {
        eventRepository.save(event);
    }

    public Iterable<Event> findAll() {
        return eventRepository.findAll();
    }

    public Event findOne(long id) {
        return eventRepository.findOne(id);
    }
}
