package com.example.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service

public class EventService {

    @Autowired
    private EventRepository eventRepository;


    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Optional<Event> getEventById(Long id) {
        return eventRepository.findById(id);
    }

    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    public Event updateEvent(Long id, Event updatedEvent) {
        if (eventRepository.existsById(id)) {
            updatedEvent.setId( id);
            return eventRepository.save(updatedEvent);
        } else {
            throw new RuntimeException("Event not found with id: " + id);
        }
    }

    public void deleteEvent(Long id) {
        if (eventRepository.existsById(id)) {
            eventRepository.deleteById(id);
        } else {
            throw new RuntimeException("Event not found with id: " + id);
        }
    }
}

