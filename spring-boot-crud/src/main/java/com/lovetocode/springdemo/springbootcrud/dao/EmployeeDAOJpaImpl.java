package com.lovetocode.springdemo.springbootcrud.dao;

import com.lovetocode.springdemo.springbootcrud.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
// Uses the standard JPA API (vendor-independent)
public class EmployeeDAOJpaImpl implements EmployeeDAO {

    private final EntityManager entityManager;

    @Autowired
    public EmployeeDAOJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        var query = entityManager.createQuery("from Employee", Employee.class);
        return query.getResultList();
    }

    @Override
    public Employee findById(int id) {
        return entityManager.find(Employee.class, id);
    }

    @Override
    public Employee saveOrUpdate(Employee employee) {
        var dbEmployee = entityManager.merge(employee);
        employee.setId(dbEmployee.getId());
        return employee;
    }

    @Override
    public int deleteById(int id) {
        var query = entityManager.createQuery("delete from Employee where id = :id");
        query.setParameter("id", id);
        return query.executeUpdate();
    }
}
