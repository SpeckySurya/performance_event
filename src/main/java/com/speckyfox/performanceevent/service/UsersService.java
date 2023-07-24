package com.speckyfox.performanceevent.service;

import com.speckyfox.performanceevent.entity.Users;
import com.speckyfox.performanceevent.repository.UsersRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UsersService {
    private UsersRepository usersRepository;


    @Autowired
    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }


    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }

    public Users getUserById(int userId) {
        return usersRepository.findById(userId).orElseThrow(EntityNotFoundException::new);
    }

    public Users createUser(Users newUser) {
        return usersRepository.save(newUser);
    }

    public Users updateUser(int userId, Users updateUser) {
        Users existingUser = usersRepository.findById(userId).orElseThrow(EntityNotFoundException::new);
        existingUser.setFirstName(updateUser.getFirstName());
        return existingUser;
    }

    public void deleteUser(int userId) {
        usersRepository.deleteById(userId);
    }
}

