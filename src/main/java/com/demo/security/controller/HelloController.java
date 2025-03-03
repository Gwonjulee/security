package com.demo.security.controller;

import com.demo.security.controller.dto.HelloRequestBody;
import com.demo.security.service.EncryptService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HelloController {

    private final EncryptService encryptService;

    @PostMapping("/api/v1/hello")
    public String hello(@RequestBody HelloRequestBody requestBody) {
        String encrypted = encryptService.encrypt(requestBody.getPassword());
        return "Hello World";
    }
}
