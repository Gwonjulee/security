package com.demo.security.controller;

import com.demo.security.controller.request.UserRegisterRequestBody;
import com.demo.security.controller.response.ResultResponse;
import com.demo.security.domain.CreateUserDto;
import com.demo.security.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final UserService userService;

    @PostMapping("/api/v1/register")
    public ResultResponse<String> register (@RequestBody UserRegisterRequestBody requestBody) {
        String result = userService.register(new CreateUserDto(requestBody.getUsername(), bCryptPasswordEncoder.encode(requestBody.getPassword())));
        return ResultResponse.ok(result);
    }
}
