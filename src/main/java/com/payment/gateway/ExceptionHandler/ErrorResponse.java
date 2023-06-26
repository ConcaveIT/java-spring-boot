package com.payment.gateway.ExceptionHandler;

public class ErrorResponse {
    private String error;
    private String message;

    // Constructors, getters, and setters

    public ErrorResponse(String error, String message) {
        this.error = error;
        this.message = message;
    }

    // Getters and setters
}
