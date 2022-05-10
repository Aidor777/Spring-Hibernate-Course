package com.lovetocode.springdemo.controller;

import com.lovetocode.springdemo.model.ErrorResponse;
import com.lovetocode.springdemo.model.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlingControllerAdvice {

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleStudentNotFoundException(StudentNotFoundException snfe) {
        return new ResponseEntity<>(new ErrorResponse(HttpStatus.NOT_FOUND.value(), snfe.getMessage(), System.currentTimeMillis()),
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(Exception e) {
        return new ResponseEntity<>(new ErrorResponse(HttpStatus.BAD_REQUEST.value(), e.getMessage(), System.currentTimeMillis()),
                HttpStatus.BAD_REQUEST);
    }
    
}
