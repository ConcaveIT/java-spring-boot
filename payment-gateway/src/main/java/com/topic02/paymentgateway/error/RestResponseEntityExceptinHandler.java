package com.topic02.paymentgateway.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.topic02.paymentgateway.entity.ErrorMessage;

@ControllerAdvice
@ResponseStatus
public class RestResponseEntityExceptinHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(PaymentTypeNotFoundException.class)
  public ResponseEntity<ErrorMessage> paymentTypeNotFoundException(PaymentTypeNotFoundException exception, WebRequest request) {
    ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
  }

}
