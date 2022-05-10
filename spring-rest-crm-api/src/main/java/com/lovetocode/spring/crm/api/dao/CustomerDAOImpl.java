package com.lovetocode.spring.crm.api.dao;

import com.lovetocode.spring.crm.api.entity.Customer;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getAll() {
        var currentSession = sessionFactory.getCurrentSession();

        var query = currentSession.createQuery("from Customer order by lastName", Customer.class);
        return query.getResultList();
    }

    @Override
    public void save(Customer customer) {
        var currentSession = sessionFactory.getCurrentSession();
        // Insert if id is null, update otherwise
        currentSession.saveOrUpdate(customer);
    }

    @Override
    public Optional<Customer> getById(int id) {
        var currentSession = sessionFactory.getCurrentSession();
        return Optional.ofNullable(currentSession.get(Customer.class, id));
    }

    @Override
    public void deleteById(int id) {
        var currentSession = sessionFactory.getCurrentSession();
        var query = currentSession.createQuery("delete from Customer where id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }
}
