package com.speckyfox.performanceevent.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Set;

@Entity
@Data
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String firstName;

    private String lastName;

    @Email
    @Column(name = "email", nullable = false, unique=true)
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

    @Column(columnDefinition="tinyint(1) default 0")
    private boolean notified;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_events",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "event_id"))
    @JsonManagedReference
    @JsonIgnore
    private Set<Events> events;
}
