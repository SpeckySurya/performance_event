package com.speckyfox.performanceevent.controller;


import com.speckyfox.performanceevent.dto.EventsRequests;
import com.speckyfox.performanceevent.entity.Events;
import com.speckyfox.performanceevent.service.EventsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {
	@Autowired
	private EventsService eventsService;

	@GetMapping
	public ResponseEntity<List<Events>> getAllEventse() {
		return ResponseEntity.ok(eventsService.findAll());
	}

	@GetMapping("/{eventId}")
	public ResponseEntity<Events> getEventsById(@PathVariable Integer eventId) {
		return ResponseEntity.ok(eventsService.findById(eventId));
	}

	@PostMapping("/save")
	public ResponseEntity<Events> saveEvents(@RequestBody EventsRequests eventsRequests) {
		eventsService.save(eventsRequests);
		return new ResponseEntity<>(HttpStatus.CREATED);
//		return ResponseEntity.status(HttpStatus.CREATED).body(eventsService.save(events));
	}

	@PutMapping
	public ResponseEntity<Events> updateEvents(@RequestBody Events events) {
		return ResponseEntity.ok(eventsService.update(events));
	}

	@DeleteMapping("/{eventId}")
	public void deleteEventsById(@PathVariable Integer eventId) {
		eventsService.deleteById(eventId);
	}

}

