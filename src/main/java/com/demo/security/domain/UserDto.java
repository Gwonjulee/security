package com.demo.security.domain;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class UserDto {
    private String username;
    private String password;
    private EncryptionAlgorithm algorithm;
    private List<AuthorityDto> authorities;
}
