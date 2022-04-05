package com.lovetocode.springdemo.service;

import com.lovetocode.springdemo.entity.Customer;
import com.lovetocode.springdemo.utils.SortColumnEnum;

import java.util.List;

public interface CustomerService {

    List<Customer> getCustomers(SortColumnEnum sortColumn);

    void saveCustomer(Customer customer);

    Customer getCustomer(int customerId);

    void deleteCustomer(int customerId);

    List<Customer> searchCustomers(String name);

}
