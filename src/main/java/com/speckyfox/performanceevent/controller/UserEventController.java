package com.speckyfox.performanceevent.controller;

import com.speckyfox.performanceevent.entity.UserEvent;
import com.speckyfox.performanceevent.entity.Users;
import com.speckyfox.performanceevent.service.UserEventService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user-events")
@RequiredArgsConstructor
public class UserEventController {
	private final UserEventService userEventService;

	@GetMapping
	@ApiOperation(value = "", nickname = "getAllUserEvents")
	public ResponseEntity<List<UserEvent>> getAllUserEvents() {
		return ResponseEntity.ok(userEventService.findAll());
	}

	@GetMapping("/{userId}/{eventId}")
	@ApiOperation(value = "", nickname = "getUserEventById")
	public ResponseEntity<UserEvent> getUserEventById(@PathVariable Users userId, @PathVariable Integer eventId) {
		return ResponseEntity.ok(userEventService.findById(userId, eventId));
	}

	@PostMapping
	@ApiOperation(value = "", nickname = "saveUserEvent")
	public ResponseEntity<UserEvent> saveUserEvent(@RequestBody UserEvent userEvent) {
		return ResponseEntity.status(HttpStatus.CREATED).body(userEventService.save(userEvent));
	}

	@PutMapping
	@ApiOperation(value = "", nickname = "updateUserEvent")
	public ResponseEntity<UserEvent> updateUserEvent(@RequestBody UserEvent userEvent) {
		return ResponseEntity.ok(userEventService.update(userEvent));
	}

	@DeleteMapping("/{userId}/{eventId}")
	@ApiOperation(value = "", nickname = "deleteUserEventById")
	public void deleteUserEventById(@PathVariable Users userId, @PathVariable Integer eventId) {
		userEventService.deleteById(userId, eventId);
	}

}

