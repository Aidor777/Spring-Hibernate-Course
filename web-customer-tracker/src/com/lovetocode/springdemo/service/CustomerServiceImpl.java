package com.lovetocode.springdemo.service;

import com.lovetocode.springdemo.dao.CustomerDAO;
import com.lovetocode.springdemo.entity.Customer;
import com.lovetocode.springdemo.utils.SortColumnEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDAO customerDAO;

    @Override
    @Transactional
    public List<Customer> getCustomers(SortColumnEnum sortColumn) {
        return customerDAO.getAll(sortColumn);
    }

    @Override
    @Transactional
    public void saveCustomer(Customer customer) {
        customerDAO.save(customer);
    }

    @Override
    @Transactional
    public Customer getCustomer(int customerId) {
        return customerDAO.getById(customerId);
    }

    @Override
    @Transactional
    public void deleteCustomer(int customerId) {
        customerDAO.deleteById(customerId);
    }

    @Override
    @Transactional
    public List<Customer> searchCustomers(String name) {
        return customerDAO.searchByName(name);
    }
}
