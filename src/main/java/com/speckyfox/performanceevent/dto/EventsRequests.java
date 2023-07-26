package com.speckyfox.performanceevent.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.ToString;

import java.sql.Time;
import java.util.Date;


@Data
@ToString
public class EventsRequests {

    @NotBlank
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


}
