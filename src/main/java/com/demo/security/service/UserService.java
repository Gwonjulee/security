package com.demo.security.service;

import com.demo.security.domain.CreateUserDto;
import com.demo.security.domain.UserDto;
import com.demo.security.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public String register(CreateUserDto createUserDto) {
        if (userRepository.userExits(createUserDto.getUsername())) {
            throw new RuntimeException("Username is already in use");
        }
        return userRepository.createUser(createUserDto).getUsername();
    }

    public UserDto getUserByUsername(String username) {
        return userRepository.getUserByUsername(username);
    }
}
