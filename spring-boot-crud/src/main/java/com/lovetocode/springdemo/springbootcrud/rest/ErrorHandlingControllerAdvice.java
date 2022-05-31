package com.lovetocode.springdemo.springbootcrud.rest;

import com.lovetocode.springdemo.springbootcrud.model.exception.EmployeeNotFoundException;
import com.lovetocode.springdemo.springbootcrud.model.technical.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandlingControllerAdvice {

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleEmployeeNotFoundException(EmployeeNotFoundException enfe) {
        return new ResponseEntity<>(new ErrorResponse(HttpStatus.NOT_FOUND.value(), enfe.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(Exception e) {
        return new ResponseEntity<>(new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
