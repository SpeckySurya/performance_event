package com.speckyfox.performanceevent.service;



import com.speckyfox.performanceevent.dto.EventsRequests;
import com.speckyfox.performanceevent.entity.Events;

import java.util.List;

public interface EventsService {

	List<Events> findAll();

	Events save(EventsRequests eventsRequests);

	Events update(Events events);

	Events findById(Integer eventId);

	void deleteById(Integer eventId);

}