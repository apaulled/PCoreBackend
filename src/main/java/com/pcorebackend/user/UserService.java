package com.pcorebackend.user;

import com.pcorebackend.user.dto.UserDto;

public interface UserService {

    UserDto newUser(String username);

}
