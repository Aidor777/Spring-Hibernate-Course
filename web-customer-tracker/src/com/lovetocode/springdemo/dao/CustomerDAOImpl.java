package com.lovetocode.springdemo.dao;

import com.lovetocode.springdemo.entity.Customer;
import com.lovetocode.springdemo.utils.SortColumnEnum;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getAll(SortColumnEnum sortColumn) {
        var currentSession = sessionFactory.getCurrentSession();
        String sortByColumn = sortColumn == null ? "lastName" : sortColumn.getColumnName();

        var query = currentSession.createQuery("from Customer order by " + sortByColumn, Customer.class);
        return query.getResultList();
    }

    @Override
    public void save(Customer customer) {
        var currentSession = sessionFactory.getCurrentSession();
        // Insert if id is null, update otherwise
        currentSession.saveOrUpdate(customer);
    }

    @Override
    public Customer getById(int id) {
        var currentSession = sessionFactory.getCurrentSession();
        return currentSession.get(Customer.class, id);
    }

    @Override
    public void deleteById(int id) {
        var currentSession = sessionFactory.getCurrentSession();
        var query = currentSession.createQuery("delete from Customer where id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    public List<Customer> searchByName(String name) {
        if (name == null || name.trim().length() == 0) {
            return getAll(null);
        }

        var currentSession = sessionFactory.getCurrentSession();
        var query = currentSession.createQuery("from Customer where lower(firstName) like :name " +
                "or lower(lastName) like :name order by lastName", Customer.class);
        query.setParameter("name", "%" + name.toLowerCase() + "%");
        return query.getResultList();
    }
}
