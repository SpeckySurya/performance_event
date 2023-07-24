package com.speckyfox.performanceevent.service.impl;

import com.speckyfox.performanceevent.entity.Users;
import com.speckyfox.performanceevent.repository.EventsRepository;
import com.speckyfox.performanceevent.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private EventsRepository eventsRepository;

    @Override
    public List<Users> findAll() {
        return null;
    }

    @Override
    public Users findById(Integer eventId) {
        return null;
    }

    @Override
    public Users save(Users events) {
        return null;
    }

    @Override
    public Users update(Users events) {
        return null;
    }

    @Override
    public void deleteById(Integer eventId) {

    }
}
