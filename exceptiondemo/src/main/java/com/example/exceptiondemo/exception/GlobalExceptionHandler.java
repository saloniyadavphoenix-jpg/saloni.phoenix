package com.example.exceptiondemo.exception;

import com.example.exceptiondemo.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // 404
    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleNotFound(ResourceNotFoundException ex) {
        return new ErrorResponse(
                LocalDateTime.now(),
                ex.getMessage(),
                "Resource not found"
        );
    }

    // 400
    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleBadRequest(BadRequestException ex) {
        return new ErrorResponse(
                LocalDateTime.now(),
                ex.getMessage(),
                "Bad request"
        );
    }

    // 409
    @ExceptionHandler(DuplicateResourceException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponse handleDuplicate(DuplicateResourceException ex) {
        return new ErrorResponse(
                LocalDateTime.now(),
                ex.getMessage(),
                "Duplicate resource"
        );
    }

    // Validation errors
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleValidation(MethodArgumentNotValidException ex) {
        String msg = ex.getBindingResult()
                .getFieldErrors()
                .get(0)
                .getDefaultMessage();

        return new ErrorResponse(
                LocalDateTime.now(),
                msg,
                "Validation failed"
        );
    }

    // Generic exception
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleAll(Exception ex) {
        return new ErrorResponse(
                LocalDateTime.now(),
                ex.getMessage(),
                "Internal server error"
        );
    }
}