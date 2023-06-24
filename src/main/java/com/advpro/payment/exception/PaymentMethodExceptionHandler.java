package com.advpro.payment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PaymentMethodExceptionHandler {

    @ExceptionHandler(value = {PaymentMethodNotFoundException.class})
    public ResponseEntity<Object> handleCloudVendorNotFoundException
        (PaymentMethodNotFoundException paymentMethodNotFoundException) {
        PaymentMethodException paymentMethodException = new PaymentMethodException(
                paymentMethodNotFoundException.getMessage(),
                paymentMethodNotFoundException.getCause(),
                HttpStatus.NOT_FOUND
        );

        return new ResponseEntity<>(paymentMethodException, HttpStatus.NOT_FOUND);
    }
    
}
