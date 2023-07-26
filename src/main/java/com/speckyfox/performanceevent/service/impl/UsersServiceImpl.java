package com.speckyfox.performanceevent.service.impl;

import com.speckyfox.performanceevent.entity.Events;
import com.speckyfox.performanceevent.entity.Users;
import com.speckyfox.performanceevent.repository.EventsRepository;
import com.speckyfox.performanceevent.repository.UsersRepository;
import com.speckyfox.performanceevent.service.UsersService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private EventsRepository eventsRepository;

    @Override
    public List<Users> findAll() {
        return usersRepository.findAll();
    }

    @Override
    public Users findById(Integer userId) {
        Optional<Users> optionalUsers = usersRepository.findById(userId.longValue());
        if (optionalUsers.isPresent()) {
            return optionalUsers.get();
        }
        throw new EntityNotFoundException("");
    }

    @Override
    public Users save(Users users) {
        return usersRepository.save(users);
    }

    @Override
    public Users update(Users users) {
        return null;
    }

    @Override
    public void deleteById(Integer userId) {

    }

    @Override
    public Integer count() {
        return Math.toIntExact(usersRepository.count());
    }

    @Override
    public List<Users> getUsersByNotificationStatus(Boolean status) {
        return new ArrayList<>();
    }

    public void addEventToUser(Long userId, Long eventId) {
        Users user = usersRepository.findById(userId).orElse(null);
        Events event = eventsRepository.findById(eventId).orElse(null);

        if (user != null && event != null) {
            user.getEvents().add(event);
            usersRepository.save(user);
        }
    }

    public void removeEventFromUser(Long userId, Long eventId) {
        Users user = usersRepository.findById(userId).orElse(null);
        Events event = eventsRepository.findById(eventId).orElse(null);

        if (user != null && event != null) {
            user.getEvents().remove(event);
            usersRepository.save(user);
        }
    }
}
