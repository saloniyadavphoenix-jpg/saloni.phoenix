package com.example.jwtfilter.dto;

import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;
}
