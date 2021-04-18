package com.rbs.primenumber.exception;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class PrimeNumberExceptionHandler extends ResponseEntityExceptionHandler {

    private ResponseEntity<Object> buildResponseEntity(PrimeNumberError primeNumberError) {
        return new ResponseEntity<>(primeNumberError, primeNumberError.getStatus());
    }

    @ExceptionHandler(PrimeNumberException.class)
    protected ResponseEntity<Object> handlePrimeNumberException(PrimeNumberException ex) {
        PrimeNumberError apiError = new PrimeNumberError(HttpStatus.BAD_REQUEST);
        apiError.setMessage(ex.getMessage());
        return buildResponseEntity(apiError);
    }
}
