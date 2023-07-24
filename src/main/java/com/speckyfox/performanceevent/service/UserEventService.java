package com.speckyfox.performanceevent.service;


import com.speckyfox.performanceevent.entity.UserEvent;
import com.speckyfox.performanceevent.entity.Users;

import java.util.List;

public interface UserEventService {

	List<UserEvent> findAll();

	UserEvent save(UserEvent userEvent);

	UserEvent update(UserEvent userEvent);

	UserEvent findById(Users userId, Integer eventId);

	void deleteById(Users userId, Integer eventId);

}