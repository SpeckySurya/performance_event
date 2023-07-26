package com.speckyfox.performanceevent.controller;

import com.speckyfox.performanceevent.dto.UsersRequest;
import com.speckyfox.performanceevent.entity.Events;
import com.speckyfox.performanceevent.service.domain.FrontDomainService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/app")
public class FrontController {

    private final FrontDomainService frontDomainService;

    public FrontController(FrontDomainService frontDomainService) {
        this.frontDomainService = frontDomainService;
    }


    /**
     * Get event by id
     *
     * @param id Integer
     * @return Events
     */
    @GetMapping("/event/{id}")
    @Operation(summary = "Get event by id")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Successfully retrieve the result"),
                    @ApiResponse(responseCode = "400", description = "Bad Request"),
                    @ApiResponse(responseCode = "500", description = "Internal Server Error")
            }
    )
    public ResponseEntity<Events> eventsById(@PathVariable("id") Integer id){
        return new ResponseEntity<>(frontDomainService.getByEventId(id), HttpStatus.OK);
    }

    /**
     * Save user
     *
     * @param usersRequest UserRequest
     * @return Boolean
     */
    @PostMapping("/register")
    @Operation(summary = "Register user for event")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Successfully retrieve the result"),
                    @ApiResponse(responseCode = "201", description = "Successfully registered"),
                    @ApiResponse(responseCode = "400", description = "Bad Request"),
                    @ApiResponse(responseCode = "500", description = "Internal Server Error")
            }
    )
    public ResponseEntity<Boolean> registerUserForEvent(@Valid @RequestBody UsersRequest usersRequest) {
        return new ResponseEntity<>(frontDomainService.registerUser(usersRequest), HttpStatus.OK);
    }



}
