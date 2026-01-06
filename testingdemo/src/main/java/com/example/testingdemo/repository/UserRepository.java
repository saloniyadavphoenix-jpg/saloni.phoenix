package com.example.testingdemo.repository;

import com.example.testingdemo.model.User;
import java.util.Optional;

public interface UserRepository {
    User save(User user);
    Optional<User> findById(Long id);
}
