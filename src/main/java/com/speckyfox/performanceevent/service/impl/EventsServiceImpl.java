package com.speckyfox.performanceevent.service.impl;

import com.speckyfox.performanceevent.dto.EventsRequests;
import com.speckyfox.performanceevent.entity.Events;
import com.speckyfox.performanceevent.entity.Users;
import com.speckyfox.performanceevent.exception.CustomException;
import com.speckyfox.performanceevent.repository.EventsRepository;
import com.speckyfox.performanceevent.repository.UsersRepository;
import com.speckyfox.performanceevent.service.EventsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EventsServiceImpl implements EventsService {

	private final EventsRepository eventsRepository;
	private final UsersRepository usersRepository;

	@Override
	public List<Events> findAll() {
		return eventsRepository.findAll();
	}

	@Override
	public Events findById(Integer eventId) {
		return eventsRepository.findById(Long.valueOf(eventId))
				.orElseThrow(() -> new NoSuchElementException("Event not found"));
	}

	@Override
	public Events save(EventsRequests eventsRequests) {
		Events events = new Events();
		events.setTitle(eventsRequests.getTitle());
		events.setTime(eventsRequests.getTime());
		events.setDate(eventsRequests.getDate());
		events.setTitle(eventsRequests.getTitle());
		events.setSpeakerName(eventsRequests.getSpeakerName());
		events.setSpeakerDesignation(eventsRequests.getSpeakerDesignation());
		events.setMeetingUrl(eventsRequests.getMeetingUrl());
		events.setDescription(eventsRequests.getDescription());
		events.setLocation(eventsRequests.getLocation());
		return eventsRepository.save(events);
	}

	@Override
	public Events update(Integer eventId, EventsRequests eventsRequests) {
		Optional<Events> eventsOptional = eventsRepository.findById(Long.valueOf(eventId));
		if (eventsOptional.isPresent()) {
			var events = eventsOptional.get();
			events.setTitle(eventsRequests.getTitle());
			events.setTime(eventsRequests.getTime());
			events.setDate(eventsRequests.getDate());
			events.setTitle(eventsRequests.getTitle());
			events.setSpeakerName(eventsRequests.getSpeakerName());
			events.setSpeakerDesignation(eventsRequests.getSpeakerDesignation());
			events.setMeetingUrl(eventsRequests.getMeetingUrl());
			events.setDescription(eventsRequests.getDescription());
			events.setLocation(eventsRequests.getLocation());
			eventsRepository.save(events);
		}
		throw new CustomException("Event not found");
	}

	@Override
	public void deleteById(Integer eventId) {
		eventsRepository.deleteById(Long.valueOf(eventId));
	}


	@Override
	public Events getByName(String name) {
		var eventOptional = eventsRepository.findEventByTitle(name);
		if (eventOptional.isPresent()) {
			return eventOptional.get();
		}
		throw new CustomException("No event found");
	}

	public void addUserToEvent(Long eventId, Long userId) {
		Events event = eventsRepository.findById(eventId).orElse(null);
		Users user = usersRepository.findById(userId).orElse(null);

		if (event != null && user != null) {
			event.getUsers().add(user);
			eventsRepository.save(event);
		}
	}

	public void removeUserFromEvent(Long eventId, Long userId) {
		Events event = eventsRepository.findById(eventId).orElse(null);
		Users user = usersRepository.findById(userId).orElse(null);

		if (event != null && user != null) {
			event.getUsers().remove(user);
			eventsRepository.save(event);
		}
	}

}