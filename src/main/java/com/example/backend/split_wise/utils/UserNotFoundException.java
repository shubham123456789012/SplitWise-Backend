package com.example.backend.split_wise.utils;

public class UserNotFoundException extends RuntimeException {
    String message;

    public UserNotFoundException(String message) {
        super(message);
        this.message = message;
    }
}
