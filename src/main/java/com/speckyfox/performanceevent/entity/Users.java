package com.speckyfox.performanceevent.entity;

import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    private String firstName;

    private String lastName;

    @Email
    private String email;

    private String companyName;

    private String designation;

    private String mobileNumber;

    private boolean isPtNeeded;

    private boolean isAnyPtToolUsed;



}
