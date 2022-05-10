package com.lovetocode.spring.crm.client.service;

import com.lovetocode.spring.crm.client.model.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getCustomers();

    void saveCustomer(Customer customer);

    Customer getCustomer(int customerId);

    void deleteCustomer(int customerId);

}
