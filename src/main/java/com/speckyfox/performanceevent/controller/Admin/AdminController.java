package com.speckyfox.performanceevent.controller.Admin;

import com.speckyfox.performanceevent.dto.AdminLoginRequest;
import com.speckyfox.performanceevent.dto.EventsRequests;
import com.speckyfox.performanceevent.dto.UserEmailNotificationRequest;
import com.speckyfox.performanceevent.dto.UsersRequest;
import com.speckyfox.performanceevent.entity.Events;
import com.speckyfox.performanceevent.entity.Users;
import com.speckyfox.performanceevent.service.EventsService;
import com.speckyfox.performanceevent.service.LoginService;
import com.speckyfox.performanceevent.service.UsersService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UsersService usersService;

    @Autowired
    private EventsService eventsService;

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    @Operation(summary = "Rest api for admin login")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Successfully retrieve the result"),
                    @ApiResponse(responseCode = "202", description = "Successfully login"),
                    @ApiResponse(responseCode = "400", description = "Bad Request"),
                    @ApiResponse(responseCode = "500", description = "Internal Server Error")
            }
    )
    public ResponseEntity<String> login(@RequestBody AdminLoginRequest adminLoginRequest) {
        return loginService.isLoginValid(adminLoginRequest) ? new ResponseEntity<>("Login successful", HttpStatus.ACCEPTED) : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }


    /**
     * Get admin event list
     *
     * @return List of events
     */
    @GetMapping("/event-list")
    public ResponseEntity<List<Events>> getAllEvents() {
        return new ResponseEntity<>(eventsService.findAll(), HttpStatus.OK);
    }

    /**
     * Get event by id
     *
     * @param id Integer
     * @return Event
     */
    @GetMapping("/get-event/{id}")
    public ResponseEntity<Events> getEvent(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(eventsService.findById(id), HttpStatus.OK);
    }

    /**
     * Update event
     *
     * @param eventId Integer
     * @param eventsRequests EventRequests
     * @return Events
     */
    @PutMapping("/update-event/{eventId}")
    public ResponseEntity<Events> updateEvent(@PathVariable("eventId") Integer eventId, @RequestBody @Valid EventsRequests eventsRequests) {
        return new ResponseEntity<>(eventsService.update(eventId, eventsRequests), HttpStatus.ACCEPTED);
    }

    /**
     * Get user list
     *
     * @return List of users
     */
    @GetMapping("/user-list")
    public ResponseEntity<List<Users>> getAllUserList() {
        return new ResponseEntity<>(usersService.findAll(), HttpStatus.OK);
    }




}
