package com.speckyfox.performanceevent.controller;


import com.speckyfox.performanceevent.entity.Users;
import com.speckyfox.performanceevent.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UsersService usersService;

	@GetMapping
	public ResponseEntity<List<Users>> getAllUsers() {
		return ResponseEntity.ok(usersService.findAll());
	}

	@GetMapping("/{userId}")
	public ResponseEntity<Users> getUsersById(@PathVariable Integer userId) {
		return ResponseEntity.ok(usersService.findById(userId));
	}

	@PostMapping
	public ResponseEntity<Users> saveUsers(@RequestBody Users users) {
		return ResponseEntity.status(HttpStatus.CREATED).body(usersService.save(users));
	}

	@PutMapping
	public ResponseEntity<Users> updateUsers(@RequestBody Users users) {
		return ResponseEntity.ok(usersService.update(users));
	}

	@DeleteMapping("/{userId}")
	public void deleteUsersById(@PathVariable Integer userId) {
		usersService.deleteById(userId);
	}

}

