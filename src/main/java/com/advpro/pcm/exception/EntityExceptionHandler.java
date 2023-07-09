package com.advpro.pcm.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EntityExceptionHandler {

    @ExceptionHandler(value = {EntityNotFoundException.class})
    public ResponseEntity<Object> handleCloudVendorNotFoundException
        (EntityNotFoundException entityNotFoundException) {

        EntityException entityException = new EntityException(
            entityNotFoundException.getMessage(),
            entityNotFoundException.getCause(),
            HttpStatus.NOT_FOUND
        );

        return new ResponseEntity<>(entityException, HttpStatus.NOT_FOUND);
    }
    
}
