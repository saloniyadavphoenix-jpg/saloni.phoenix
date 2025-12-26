package com.example.exceptiondemo.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class User {

    @NotBlank(message = "Username required")
    private String username;

    @Email(message = "Invalid email")
    private String email;
}
