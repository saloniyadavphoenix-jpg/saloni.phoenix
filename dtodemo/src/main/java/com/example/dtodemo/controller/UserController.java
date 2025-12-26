package com.example.dtodemo.controller;

import com.example.dtodemo.dto.*;
import com.example.dtodemo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @PostMapping
    public UserDTO create(@RequestBody CreateUserRequest req) {
        return service.create(req);
    }
}
