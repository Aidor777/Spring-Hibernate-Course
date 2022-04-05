package com.lovetocode.springdemo.dao;

import com.lovetocode.springdemo.entity.Customer;
import com.lovetocode.springdemo.utils.SortColumnEnum;

import java.util.List;

public interface CustomerDAO {

    List<Customer> getAll(SortColumnEnum sortColumn);

    void save(Customer customer);

    Customer getById(int id);

    void deleteById(int id);

    List<Customer> searchByName(String name);

}
