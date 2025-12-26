package com.example.validationdemo.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class UserRegisterDTO {

    @NotBlank(message = "Username required")
    private String username;

    @Email(message = "Invalid email")
    @NotBlank(message = "Email required")
    private String email;

    @NotBlank(message = "Password required")
    @Size(min = 8, message = "Password must be at least 8 characters")
    @Pattern(regexp = ".*\\d.*", message = "Password must contain at least one number")
    private String password;
}
