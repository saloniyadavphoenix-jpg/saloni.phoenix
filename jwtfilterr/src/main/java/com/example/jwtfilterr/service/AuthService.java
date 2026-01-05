package com.example.jwtfilterr.service;

import com.example.jwtfilterr.model.*;
import com.example.jwtfilterr.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    public void register(String username, String password) {

        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));

        // DEFAULT ROLE
        user.setRole(Role.USER);

        repository.save(user);
    }
}
