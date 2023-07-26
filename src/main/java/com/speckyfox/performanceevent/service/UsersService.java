package com.speckyfox.performanceevent.service;

import com.speckyfox.performanceevent.dto.AdminLoginRequest;
import com.speckyfox.performanceevent.entity.Users;

import java.util.List;
public interface UsersService {

    List<Users> findAll();

    Users findById(Integer userId);

    Users save(Users users);

    Users update(Users users);

    void deleteById(Integer userId);

    Integer count();

    List<Users> getUsersByNotificationStatus(Boolean status);

}

