package com.topic03mohosin.topic03mohosin.exception;

import org.springframework.http.HttpStatus;

public class APIException extends RuntimeException{
    
    private HttpStatus status;
    private String message;

    public APIException(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }
    public APIException(String arg0, HttpStatus status, String message) {
        super(arg0);
        this.status = status;
        this.message = message;
    }
    
    public HttpStatus getStatus() {
        return status;
    }
    public String getMessage() {
        return message;
    }


    

}