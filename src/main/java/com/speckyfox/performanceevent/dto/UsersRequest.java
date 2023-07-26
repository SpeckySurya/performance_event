package com.speckyfox.performanceevent.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UsersRequest {


    private String firstName;

    private String lastName;

    @Email
    private String email;

    @NotBlank
    private String companyName;

    @NotBlank
    private String designation;

    @NotBlank
    private String mobileNumber;

    @NotNull
    private boolean isPtNeeded;

    @NotNull
    private boolean isAnyPtToolUsed;

    @NotNull
    private Integer eventId;


}
