package com.example.exceptiondemo.service;

import com.example.exceptiondemo.exception.*;
import com.example.exceptiondemo.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public User getUserById(Long id) {
        if (id == 99) {
            throw new ResourceNotFoundException("User not found with id " + id);
        }
        return new User();
    }

    public User createUser(User user) {
        if ("duplicate@gmail.com".equals(user.getEmail())) {
            throw new DuplicateResourceException("Email already exists");
        }
        return user;
    }

    public void badRequest() {
        throw new BadRequestException("Invalid request data");
    }
}