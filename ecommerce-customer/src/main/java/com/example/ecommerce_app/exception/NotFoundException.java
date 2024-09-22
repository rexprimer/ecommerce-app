package com.example.ecommerce_app.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String entity, Long id) {
        super(entity + " with ID " + id + " not found.");
    }
}
