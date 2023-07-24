package com.speckyfox.performanceevent.service.impl;

import com.speckyfox.performanceevent.entity.UserEvent;
import com.speckyfox.performanceevent.repository.UserEventRepository;
import io.swagger.annotations.Authorization;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserEventServiceImpl {

	@Autowired
	private UserEventRepository userEventRepository;

	public List<UserEvent> getAllUserEvents() {
		return userEventRepository.findAll();
	}

	public UserEvent getUserEventById(int userEventId) {
		return userEventRepository.findById(userEventId).orElseThrow(EntityNotFoundException::new);
	}

	public UserEvent createUserEvent(UserEvent newUserEvent) {
		return userEventRepository.save(newUserEvent);
	}
}