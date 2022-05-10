package com.lovetocode.spring.crm.api.controller;

import com.lovetocode.spring.crm.api.model.CustomerNotFoundException;
import com.lovetocode.spring.crm.api.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlingControllerAdvice {

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleCustomerNotFoundException(CustomerNotFoundException cnfe) {
        return new ResponseEntity<>(new ErrorResponse(HttpStatus.NOT_FOUND.value(), cnfe.getMessage(), System.currentTimeMillis()),
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(Exception e) {
        return new ResponseEntity<>(new ErrorResponse(HttpStatus.BAD_REQUEST.value(), e.getMessage(), System.currentTimeMillis()),
                HttpStatus.BAD_REQUEST);
    }

}
