package com.speckyfox.performanceevent.controller;


import com.speckyfox.performanceevent.dto.EventsRequests;
import com.speckyfox.performanceevent.entity.Events;
import com.speckyfox.performanceevent.service.EventsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/events")
public class EventController {
	@Autowired
	private EventsService eventsService;

	@GetMapping
	public ResponseEntity<List<Events>> getAllEvents() {
		return ResponseEntity.ok(eventsService.findAll());
	}

	@GetMapping("/{eventId}")
	public ResponseEntity<Events> getEventsById(@PathVariable Integer eventId) {
		return ResponseEntity.ok(eventsService.findById(eventId));
	}

	@PostMapping("/save")
	public ResponseEntity<Events> saveEvents(@RequestBody EventsRequests eventsRequests) {
		log.debug("save function called");
		eventsService.save(eventsRequests);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@PutMapping("/update/{eventId}")
	public ResponseEntity<Events> updateEvents(Integer eventId, @RequestBody EventsRequests eventsRequests) {
		return ResponseEntity.ok(eventsService.update(eventId, eventsRequests));
	}

	@DeleteMapping("/{eventId}")
	public void deleteEventsById(@PathVariable Integer eventId) {
		eventsService.deleteById(eventId);
	}


}

