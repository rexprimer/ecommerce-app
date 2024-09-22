package com.example.ecommerce_app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<String> globalExceptionHandler(NotFoundException nex) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(nex.getMessage());
    }

    @ExceptionHandler(InvalidInputException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<String> globalExceptionHandler(InvalidInputException inex) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(inex.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<String> globalExceptionHandler(RuntimeException rex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("An unexpected error occured : " +rex.getMessage());
    }
}
