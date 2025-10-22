package com.hexaware.beneficiary.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BeneficiaryControllerAdvice {
    @ExceptionHandler(IndexOutOfBoundsException.class)
    public ResponseEntity<String> handleException(IndexOutOfBoundsException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND) ;
    }
}