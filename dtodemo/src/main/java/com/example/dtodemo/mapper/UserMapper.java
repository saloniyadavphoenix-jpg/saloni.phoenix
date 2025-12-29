package com.example.dtodemo.mapper;

import com.example.dtodemo.dto.CreateUserRequest;
import com.example.dtodemo.dto.UserDTO;
import com.example.dtodemo.dto.UserSummaryDTO;
import com.example.dtodemo.model.User;

public class UserMapper {

    // Request → Entity
    public static User toEntity(CreateUserRequest req) {
        User user = new User();
        user.setUsername(req.getUsername());
        user.setEmail(req.getEmail());
        user.setPassword(req.getPassword());
        return user;
    }

    // Entity → DTO
    public static UserDTO toDTO(User user) {
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setEmail(user.getEmail());
        return dto;
    }

    // Mini Task
    public static UserSummaryDTO toSummary(User user) {
        return new UserSummaryDTO(user.getId(), user.getUsername());
    }
}
