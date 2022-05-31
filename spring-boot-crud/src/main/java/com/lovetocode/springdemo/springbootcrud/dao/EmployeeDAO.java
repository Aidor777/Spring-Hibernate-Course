package com.lovetocode.springdemo.springbootcrud.dao;

import com.lovetocode.springdemo.springbootcrud.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();

    Employee findById(int id);

    Employee saveOrUpdate(Employee employee);

    int deleteById(int id);

}
