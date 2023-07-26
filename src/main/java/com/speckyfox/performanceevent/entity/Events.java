package com.speckyfox.performanceevent.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.sql.Time;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "events")
public class Events {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false, unique = true)
    private String title;

    @NotBlank
    private String description;

    @NotNull
    private Date date;

    @NotNull
    private Time time;

    @NotBlank
    private String speakerName;

    @NotBlank
    private String speakerDesignation;

    @NotBlank
    private String meetingUrl;

    @NotBlank
    private String location;

    @ManyToMany(mappedBy = "events")
    @JsonManagedReference
    private Set<Users> users;

}
