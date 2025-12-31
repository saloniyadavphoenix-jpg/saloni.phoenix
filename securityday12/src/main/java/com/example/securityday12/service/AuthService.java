package com.example.securityday12.service;

import com.example.securityday12.model.User;
import com.example.securityday12.exception.DuplicateEmailException;
import com.example.securityday12.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    public void register(String email, String password) {

        if (repository.findByEmail(email).isPresent()) {
            throw new DuplicateEmailException("Email already exists");
        }

        User user = new User();
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));
        user.setRole("USER");

        repository.save(user);
    }
}
