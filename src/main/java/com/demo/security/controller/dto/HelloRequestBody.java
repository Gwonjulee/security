package com.demo.security.controller.dto;

import com.demo.security.annotation.CustomEncryption;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class HelloRequestBody {

    private String id;

    @CustomEncryption
    private String password;
}
