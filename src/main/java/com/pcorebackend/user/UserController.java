package com.pcorebackend.user;

import com.pcorebackend.user.dto.NewUserRequest;
import com.pcorebackend.user.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PutMapping(value = "/", produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public UserDto newUser(@RequestBody NewUserRequest request) {
        return userService.newUser(request.username());
    }
}
