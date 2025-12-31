package com.example.securityday12.exception;

import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DuplicateEmailException.class)
    public String handleDuplicate(DuplicateEmailException ex) {
        return ex.getMessage();
    }
}
