package com.example.jwtfilter.controller;

import com.example.jwtfilter.dto.*;
import com.example.jwtfilter.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;
import java.util.HashMap;
import java.util.Map;



@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        System.out.println(">>> /api/auth/me HIT <<<");

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        String token = jwtUtil.generateToken(request.getUsername());
        return ResponseEntity.ok(new LoginResponse(token));
    }

    @GetMapping("/me")
    public ResponseEntity<Map<String, String>> me(Authentication authentication) {

        Map<String, String> response = new HashMap<>();

        if (authentication == null) {
            response.put("message", "Not authenticated");
            return ResponseEntity.ok(response);
        }

        response.put("username", authentication.getName());
        return ResponseEntity.ok()
                .header("X-Debug", "ME-ENDPOINT-HIT")
                .body(Map.of("username", authentication.getName()));

    }

}
