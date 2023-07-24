package com.speckyfox.performanceevent.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "events")
public class Events {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_id")
    private Long id;
    @Column(name = "title", nullable = false)
    private String title;
    private String description;
    private String date;
    private String time;
    private String speakerName;
    private String speakerDesigntion;
    private String meetingUrl;

}
