package com.lovetocode.springdemo.springbootcrud.model.exception;

public class EmployeeNotFoundException extends RuntimeException {

    public EmployeeNotFoundException(int id) {
        super("Could not find employee with ID " + id);
    }

}
