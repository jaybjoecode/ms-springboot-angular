package com.example.apiserver.core;

public class CustomError extends RuntimeException {
    public CustomError(String message) {
        super(message);
    }
}
