package com.example.jwtdemo.controller;

import com.example.jwtdemo.dto.LoginRequest;
import com.example.jwtdemo.dto.LoginResponse;
import com.example.jwtdemo.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.security.authentication.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getUsername(),
                            request.getPassword()
                    )
            );

            return ResponseEntity.ok("LOGIN SUCCESS");

        } catch (Exception e) {
            return ResponseEntity.status(401).body("INVALID");
        }
    }
}
