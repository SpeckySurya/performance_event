package com.speckyfox.performanceevent.service;

import com.speckyfox.performanceevent.dto.AdminLoginRequest;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private final String VALID_EMAIL = "abhishek@speckyfox.com";
    private final String PASSWORD = "specky@508";
    public boolean isLoginValid(AdminLoginRequest adminLoginRequest) {
        return adminLoginRequest.getEmail().equalsIgnoreCase(VALID_EMAIL) && adminLoginRequest.getPassword().equalsIgnoreCase(PASSWORD);
    }

}
