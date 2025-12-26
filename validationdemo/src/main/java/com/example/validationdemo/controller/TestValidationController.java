package com.example.validationdemo.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/validate")
public class TestValidationController {

    @PostMapping
    public String validate(@Valid @RequestBody Req req) {
        return "OK";
    }

    static class Req {
        @NotBlank(message = "name blank ")
        @Size(min = 3, message = "name min 3 char")
        public String name;
    }
}