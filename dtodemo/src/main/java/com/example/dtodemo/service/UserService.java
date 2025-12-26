package com.example.dtodemo.service;

import com.example.dtodemo.dto.CreateUserRequest;
import com.example.dtodemo.dto.UserDTO;
import com.example.dtodemo.mapper.UserMapper;
import com.example.dtodemo.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public UserDTO create(CreateUserRequest req) {

        // 1️⃣ Request → Entity
        User user = UserMapper.toEntity(req);

        // 2️⃣ Simulate DB save
        user.setId(1L);

        // ❗❗ IMPORTANT: username & email MUST already be in user
        // user.getUsername() & user.getEmail() should NOT be null

        // 3️⃣ Entity → DTO
        return UserMapper.toDTO(user);
    }
}
