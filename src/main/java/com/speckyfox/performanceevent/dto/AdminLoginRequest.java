package com.speckyfox.performanceevent.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class AdminLoginRequest {

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String password;


}
