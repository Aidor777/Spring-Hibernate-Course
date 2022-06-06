package com.lovetocode.springdemo.thymeleafdemo.exception;

public class EmployeeNotFoundException extends RuntimeException {

    public EmployeeNotFoundException(int id) {
        super("Could not find employee with ID " + id);
    }

}
