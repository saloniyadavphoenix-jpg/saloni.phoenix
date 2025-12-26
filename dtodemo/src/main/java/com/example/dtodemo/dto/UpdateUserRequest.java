package com.example.dtodemo.dto;

import lombok.Data;

@Data
public class UpdateUserRequest {
    private String username;
    private String email;
}
