package com.example.jwtfilter.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/test")
public class TestController {

    @GetMapping("/secure")
    public String secureApi() {
        return "JWT Protected API working";
    }

    @GetMapping("/me")
    public String me(Authentication auth) {
        return "Logged in user: " + auth.getName();
    }
}
