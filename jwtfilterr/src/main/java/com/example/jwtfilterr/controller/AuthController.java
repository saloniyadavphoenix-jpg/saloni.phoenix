package com.example.jwtfilterr.controller;

import com.example.jwtfilterr.dto.*;
import com.example.jwtfilterr.model.User;
import com.example.jwtfilterr.repository.UserRepository;
import com.example.jwtfilterr.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getUsername(),
                            request.getPassword()
                    )
            );
        } catch (BadCredentialsException e) {
            return ResponseEntity
                    .status(401)
                    .body("Invalid username or password");
        }

        User user = userRepository
                .findByUsername(request.getUsername())
                .orElseThrow();

        String token = jwtUtil.generateToken(
                user.getUsername(),
                user.getRole().name()
        );

        return ResponseEntity.ok(new LoginResponse(token));
    }
}
