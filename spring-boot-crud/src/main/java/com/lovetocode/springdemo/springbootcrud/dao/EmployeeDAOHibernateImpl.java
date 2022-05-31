package com.lovetocode.springdemo.springbootcrud.dao;

import com.lovetocode.springdemo.springbootcrud.entity.Employee;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
// Uses the native Hibernate API
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

    private final EntityManager entityManager;

    @Autowired
    public EmployeeDAOHibernateImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        var session = entityManager.unwrap(Session.class);
        var query = session.createQuery("from Employee", Employee.class);
        return query.getResultList();
    }

    @Override
    public Employee findById(int id) {
        var session = entityManager.unwrap(Session.class);
        return session.get(Employee.class, id);
    }

    @Override
    public Employee saveOrUpdate(Employee employee) {
        var session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(employee);
        return employee;
    }

    @Override
    public int deleteById(int id) {
        var session = entityManager.unwrap(Session.class);
        var query = session.createQuery("delete from Employee where id = :id");
        query.setParameter("id", id);
        return query.executeUpdate();
    }
}
