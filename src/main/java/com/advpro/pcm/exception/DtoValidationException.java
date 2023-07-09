package com.advpro.pcm.exception;

public class DtoValidationException extends RuntimeException {

    public DtoValidationException(String message) {
        super(message);
    }

    public DtoValidationException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
