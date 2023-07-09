package com.advpro.pcm.exception;

import org.springframework.http.HttpStatus;

public class DtoException {
    
    private final String[] message;
    private final Throwable throwable;
    private final HttpStatus httpStatus;

    public DtoException(String[] message, Throwable throwable, HttpStatus httpStatus) {
        this.message = message;
        this.throwable = throwable;
        this.httpStatus = httpStatus;
    }

    public String[] getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

}
