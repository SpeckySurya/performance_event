package com.speckyfox.performanceevent.service.domain;

import com.speckyfox.performanceevent.dto.UsersRequest;
import com.speckyfox.performanceevent.entity.Events;
import com.speckyfox.performanceevent.entity.Users;
import com.speckyfox.performanceevent.service.EventsService;
import com.speckyfox.performanceevent.service.UsersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@Slf4j
public class FrontDomainService {

    private final UsersService usersService;

    private final NotificationService notificationService;

    private final EventsService eventsService;


    public FrontDomainService(UsersService usersService, NotificationService notificationService, EventsService eventsService) {
        this.usersService = usersService;
        this.notificationService = notificationService;
        this.eventsService = eventsService;
    }


    /**
     * User registration error method
     *
     * @param usersRequest UserRequest
     * @return Boolean
     */
    public Boolean registerUser(UsersRequest usersRequest) {
        log.info("registered user function calling");
        try {

            Users users = new Users();
            users.setFirstName(usersRequest.getFirstName());
            users.setLastName(usersRequest.getLastName());
            users.setEmail(usersRequest.getEmail());
            users.setMobileNumber(usersRequest.getMobileNumber());
            users.setCompanyName(usersRequest.getCompanyName());
            users.setDesignation(usersRequest.getDesignation());
            users.setAnyPtToolUsed(usersRequest.isAnyPtToolUsed());
            users.setPtNeeded(usersRequest.isPtNeeded());
           // users.setNotified(notificationService.sendEmail(users.getEmail(), "surya.srivastav@gmail.com", "SuccessFully Registered"));
            var event = getByEventId(usersRequest.getEventId());
            var isNotified = notificationService.sendCalendarInvite(usersRequest.getEmail(), event);
            users.setNotified(isNotified);
            users.setEvents(Collections.singleton(getByEventId(usersRequest.getEventId())));
            usersService.save(users);
            log.info("user successfully registered");
            return true;
        }catch (Exception ex){
            log.error(ex.getMessage());
        }
        return false;
    }

    /**
     * Get By Event Id
     *
     * @param id Integer
     * @return Events
     */
    public Events getByEventId(Integer id) {
        return  eventsService.findById(id);
    }


    /**
     * Get registered user count
     *
     * @return Integer
     */
    public Integer getTotalUserCount() {
        return usersService.count();
    }

    /**
     * Get By Event Name
     *
     * @param name String
     * @return Events
     */
    public Events getByEventName(String name) {
        return eventsService.getByName(name);
    }

    public Boolean sendEmail() {
         //notificationService.sendCalendarInvite("surya.srivastav@speckyfox.com", "twinklesam76@gmail.com", "Performance Event");
    return true;
    }
}
