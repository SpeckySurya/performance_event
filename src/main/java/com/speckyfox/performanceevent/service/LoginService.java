package com.speckyfox.performanceevent.service;

import com.speckyfox.performanceevent.dto.AdminLoginRequest;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    public boolean isLoginValid(AdminLoginRequest adminLoginRequest) {
        String VALID_EMAIL = "abhishek@speckyfox.com";
        String PASSWORD = "specky@508";
        return adminLoginRequest.getEmail().equalsIgnoreCase(VALID_EMAIL) && adminLoginRequest.getPassword().equalsIgnoreCase(PASSWORD);
    }

}
