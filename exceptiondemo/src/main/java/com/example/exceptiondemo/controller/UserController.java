package com.example.exceptiondemo.controller;

import com.example.exceptiondemo.model.User;
import com.example.exceptiondemo.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    // 404 test
    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return service.getUserById(id);
    }

    // 400 validation test
    @PostMapping
    public User create(@Valid @RequestBody User user) {
        return service.createUser(user);
    }

    // 400 custom bad request
    @GetMapping("/bad")
    public void badRequest() {
        service.badRequest();
    }
}
