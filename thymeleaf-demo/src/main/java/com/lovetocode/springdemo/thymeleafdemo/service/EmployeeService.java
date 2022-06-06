package com.lovetocode.springdemo.thymeleafdemo.service;

import com.lovetocode.springdemo.thymeleafdemo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAll();

    Employee getById(int id);

    Employee save(Employee employee);

    Employee update(Employee employee);

    void deleteById(int id);

    List<Employee> searchByName(String name);

}
