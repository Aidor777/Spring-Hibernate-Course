package com.lovetocode.spring.crm.api.service;

import com.lovetocode.spring.crm.api.dao.CustomerDAO;
import com.lovetocode.spring.crm.api.entity.Customer;
import com.lovetocode.spring.crm.api.model.CustomerNotFoundException;
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
    public List<Customer> getCustomers() {
        return customerDAO.getAll();
    }

    @Override
    @Transactional
    public void saveCustomer(Customer customer) {
        customerDAO.save(customer);
    }

    @Override
    @Transactional
    public Customer getCustomer(int customerId) {
        return customerDAO.getById(customerId).orElseThrow(() -> new CustomerNotFoundException("Customer ID not found: " + customerId));
    }

    @Override
    @Transactional
    public void deleteCustomer(int customerId) {
        var customerToDelete = getCustomer(customerId);
        customerDAO.deleteById(customerToDelete.getId());
    }
}
