package com.example.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/events")
public class EventController {

        @Autowired
        private EventService eventService;

        @GetMapping
        public List<Event> getAllEvents() {
            return eventService.getAllEvents();
        }

        @GetMapping("/{id}")
        public ResponseEntity<Event> getEventById(@PathVariable Long id) {
            return eventService.getEventById(id)
                    .map(event -> ResponseEntity.ok().body(event))
                    .orElse(ResponseEntity.notFound().build());
        }

        @PostMapping
        public ResponseEntity<Event> createEvent(@RequestBody Event event) {
            Event createdEvent = eventService.createEvent(event);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdEvent);
        }

        @PutMapping("/{id}")
        public ResponseEntity<Event> updateEvent(@PathVariable Long id, @RequestBody Event updatedEvent) {
            Event event = eventService.updateEvent(id, updatedEvent);
            return ResponseEntity.ok().body(event);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteEvent(@PathVariable Long id) {
            eventService.deleteEvent(id);
            return ResponseEntity.noContent().build();
        }
}
