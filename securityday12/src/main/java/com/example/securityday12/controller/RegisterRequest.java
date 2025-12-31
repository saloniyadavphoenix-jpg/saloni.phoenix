package com.example.securityday12.controller;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class RegisterRequest {

    @Email
    @NotBlank
    private String email;

    @NotBlank
    @Pattern(
            regexp = "^(?=.*\\d).{8,}$",
            message = "Password must be at least 8 characters and contain a number"
    )
    private String password;
}
