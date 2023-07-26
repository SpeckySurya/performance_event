package com.speckyfox.performanceevent.dto;

import com.speckyfox.performanceevent.entity.Users;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class UserEmailNotificationRequest {

    private List<Users> userList;


}
