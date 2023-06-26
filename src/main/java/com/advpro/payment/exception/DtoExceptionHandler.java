package com.advpro.payment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DtoExceptionHandler {

    @ExceptionHandler(value = {DtoValidationException.class})
    public ResponseEntity<Object> handleDtoValidationException
        (DtoValidationException dtoValidationException) {
            String[] errorMsg = null;
            errorMsg = dtoValidationException.getMessage().split("\n");

        DtoException dtoException = new DtoException(
                errorMsg,
                dtoValidationException.getCause(),
                HttpStatus.NOT_ACCEPTABLE
        );

        return new ResponseEntity<>(dtoException, HttpStatus.NOT_ACCEPTABLE);
    }
    
}
