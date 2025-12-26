package com.example.validationdemo.controller;

import com.example.validationdemo.dto.UserRegisterDTO;
import com.example.validationdemo.model.User;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @PostMapping
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        return ResponseEntity.ok(user);
    }

    @PostMapping("/register")
    public ResponseEntity<UserRegisterDTO> register(
            @Valid @RequestBody UserRegisterDTO dto) {
        return ResponseEntity.ok(dto);
    }
}
