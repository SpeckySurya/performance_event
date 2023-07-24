package com.speckyfox.performanceevent.controller;


import com.speckyfox.performanceevent.entity.Events;
import com.speckyfox.performanceevent.service.EventsService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/eventses")
@RequiredArgsConstructor
public class EventsController {
	private final EventsService eventsService;

	@GetMapping
	@ApiOperation(value = "", nickname = "getAllEventses")
	public ResponseEntity<List<Events>> getAllEventses() {
		return ResponseEntity.ok(eventsService.findAll());
	}

	@GetMapping("/{eventId}")
	@ApiOperation(value = "", nickname = "getEventsById")
	public ResponseEntity<Events> getEventsById(@PathVariable Integer eventId) {
		return ResponseEntity.ok(eventsService.findById(eventId));
	}

	@PostMapping
	@ApiOperation(value = "", nickname = "saveEvents")
	public ResponseEntity<Events> saveEvents(@RequestBody Events events) {
		return ResponseEntity.status(HttpStatus.CREATED).body(eventsService.save(events));
	}

	@PutMapping
	@ApiOperation(value = "", nickname = "updateEvents")
	public ResponseEntity<Events> updateEvents(@RequestBody Events events) {
		return ResponseEntity.ok(eventsService.update(events));
	}

	@DeleteMapping("/{eventId}")
	@ApiOperation(value = "", nickname = "deleteEventsById")
	public void deleteEventsById(@PathVariable Integer eventId) {
		eventsService.deleteById(eventId);
	}

}

