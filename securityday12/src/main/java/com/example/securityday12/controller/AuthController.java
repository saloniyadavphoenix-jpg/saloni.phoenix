package com.example.securityday12.controller;

import com.example.securityday12.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService service;

    @PostMapping("/register")
    public String register(@Valid @RequestBody RegisterRequest request) {
        service.register(request.getEmail(), request.getPassword());
        return "User registered successfully";
    }
}
