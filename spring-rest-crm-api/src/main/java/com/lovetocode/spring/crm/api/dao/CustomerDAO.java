package com.lovetocode.spring.crm.api.dao;

import com.lovetocode.spring.crm.api.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerDAO {

    List<Customer> getAll();

    void save(Customer customer);

    Optional<Customer> getById(int id);

    void deleteById(int id);

}
