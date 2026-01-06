package com.example.integrationdemo.repository;

import com.example.integrationdemo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {}
