package com.lovetocode.springdemo.thymeleafdemo.service;

import com.lovetocode.springdemo.thymeleafdemo.entity.Employee;
import com.lovetocode.springdemo.thymeleafdemo.exception.EmployeeNotFoundException;
import com.lovetocode.springdemo.thymeleafdemo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAllByOrderByLastName();
    }

    @Override
    public Employee getById(int id) {
        return employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee update(Employee employee) {
        var existingEmployee = employeeRepository.findById(employee.getId())
                .orElseThrow(() -> new EmployeeNotFoundException(employee.getId()));

        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());
        return employeeRepository.save(existingEmployee);
    }

    @Override
    public void deleteById(int id) {
        var employee = employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
        employeeRepository.delete(employee);
    }

    @Override
    public List<Employee> searchByName(String name) {
        if (StringUtils.hasLength(name)) {
            return employeeRepository.findByFirstNameContainsOrLastNameContainsAllIgnoreCase(name, name);
        } else {
            return employeeRepository.findAllByOrderByLastName();
        }
    }
}
