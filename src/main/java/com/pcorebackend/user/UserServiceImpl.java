package com.pcorebackend.user;

import com.pcorebackend.user.dto.UserDto;
import com.pcorebackend.user.jpa.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDto newUser(String username) {
        User user = new User(username);
        userRepository.save(user);
        return user.toDto();
    }

}
