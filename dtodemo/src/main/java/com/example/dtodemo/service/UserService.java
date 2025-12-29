package com.example.dtodemo.service;

import com.example.dtodemo.dto.CreateUserRequest;
import com.example.dtodemo.dto.UserDTO;
import com.example.dtodemo.mapper.UserMapper;
import com.example.dtodemo.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public UserDTO create(CreateUserRequest req) {

        //Request → Entity
        User user = UserMapper.toEntity(req);

        //Simulate DB save
        user.setId(1L);

        // user.getUsername() & user.getEmail() should NOT be null

        //Entity → DTO
        return UserMapper.toDTO(user);
    }
}