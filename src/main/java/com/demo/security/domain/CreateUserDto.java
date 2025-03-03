package com.demo.security.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateUserDto {
    private final String username;
    private final String password;
}
