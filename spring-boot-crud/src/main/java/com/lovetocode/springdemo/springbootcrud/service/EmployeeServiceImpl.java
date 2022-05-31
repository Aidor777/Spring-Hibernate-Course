package com.lovetocode.springdemo.springbootcrud.service;

import com.lovetocode.springdemo.springbootcrud.dao.EmployeeDAO;
import com.lovetocode.springdemo.springbootcrud.dao.EmployeeRepository;
import com.lovetocode.springdemo.springbootcrud.entity.Employee;
import com.lovetocode.springdemo.springbootcrud.model.exception.EmployeeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDAO employeeDAO;

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(@Qualifier("employeeDAOJpaImpl") EmployeeDAO employeeDAO, EmployeeRepository employeeRepository) {
        this.employeeDAO = employeeDAO;
        this.employeeRepository = employeeRepository;
    }

    /*@Override
    @Transactional
    public List<Employee> getAll() {
        return employeeDAO.findAll();
    }*/

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    /*@Override
    @Transactional
    public Employee getById(int id) {
        var employee = employeeDAO.findById(id);
        if (employee == null) {
            throw new EmployeeNotFoundException(id);
        }
        return employee;
    }*/

    @Override
    public Employee getById(int id) {
        return employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    /*@Override
    @Transactional
    public Employee save(Employee employee) {
        return employeeDAO.saveOrUpdate(employee);
    }*/

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    /*@Override
    @Transactional
    public Employee update(Employee employee) {
        var existingEmployee = employeeDAO.findById(employee.getId());
        if (existingEmployee == null) {
            throw new EmployeeNotFoundException(employee.getId());
        }
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());
        return employeeDAO.saveOrUpdate(existingEmployee);
    }*/

    @Override
    public Employee update(Employee employee) {
        var existingEmployee = employeeRepository.findById(employee.getId())
                .orElseThrow(() -> new EmployeeNotFoundException(employee.getId()));

        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());
        return employeeRepository.save(existingEmployee);
    }

    /*@Override
    @Transactional
    public void deleteById(int id) {
        int deletedEntries = employeeDAO.deleteById(id);
        if (deletedEntries == 0) {
            throw new EmployeeNotFoundException(id);
        }
    }*/

    @Override
    public void deleteById(int id) {
        var employee = employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
        employeeRepository.delete(employee);
    }
}
