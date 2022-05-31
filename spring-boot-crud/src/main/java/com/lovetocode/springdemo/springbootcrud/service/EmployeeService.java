package com.lovetocode.springdemo.springbootcrud.service;

import com.lovetocode.springdemo.springbootcrud.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAll();

    Employee getById(int id);

    Employee save(Employee employee);

    Employee update(Employee employee);

    void deleteById(int id);

}
