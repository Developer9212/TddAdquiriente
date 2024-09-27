package com.fenoreste_alestra.service;

import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DataAccessException.class)
    public String handleDataAccessException(DataAccessException e) {
        e.printStackTrace();
        return "Database error occurred: " + e.getMessage();
    }

    @ExceptionHandler(Exception.class)
    public String handleException(Exception e) {
        e.printStackTrace();
        return "An error occurred: " + e.getMessage();
    }
}
