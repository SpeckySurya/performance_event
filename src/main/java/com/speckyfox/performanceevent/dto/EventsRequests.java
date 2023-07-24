package com.speckyfox.performanceevent.dto;


import lombok.Data;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@Data
@ToString
public class EventsRequests {
    private long id;
    private String title;
    private String description;
    private String date;
    private String time;
    private String speakerName;
    private String speakerDesignation;
    private String meetingUrl;
//    private List<MultipartFile> multipartFiles;

}
