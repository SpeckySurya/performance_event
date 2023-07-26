package com.speckyfox.performanceevent.service.impl;

import com.speckyfox.performanceevent.dto.EventsRequests;
import com.speckyfox.performanceevent.entity.Events;
import com.speckyfox.performanceevent.repository.EventsRepository;
import com.speckyfox.performanceevent.service.EventsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class EventsServiceImpl implements EventsService {

	private final EventsRepository eventsRepository;

	@Override
	public List<Events> findAll() {
		return eventsRepository.findAll();
	}

	@Override
	public Events findById(Integer eventId) {
		return eventsRepository.findById(eventId)
				.orElseThrow(() -> new NoSuchElementException("Event not found"));
	}

	@Override
	public Events save(EventsRequests eventsRequests) {
		Events events = new Events();
		events.setTitle(eventsRequests.getTitle());
		events.setId(eventsRequests.getId());
		events.setTime(eventsRequests.getTime());
		events.setTitle(eventsRequests.getTitle());
		events.setSpeakerName(eventsRequests.getSpeakerName());
		events.setSpeakerDesigntion(eventsRequests.getSpeakerDesignation());
		events.setMeetingUrl(eventsRequests.getMeetingUrl());
		events.setDescription(eventsRequests.getDescription());
		return eventsRepository.save(events);
	}

	@Override
	public Events update(Events events) {
		return eventsRepository.save(events);
	}

	@Override
	public void deleteById(Integer eventId) {
		eventsRepository.deleteById(eventId);
	}


}