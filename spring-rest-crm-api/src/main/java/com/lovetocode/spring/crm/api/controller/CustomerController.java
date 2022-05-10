package com.lovetocode.spring.crm.api.controller;

import com.lovetocode.spring.crm.api.entity.Customer;
import com.lovetocode.spring.crm.api.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public List<Customer> getCustomers() {
        return customerService.getCustomers();
    }

    @GetMapping("/{customerId}")
    public Customer getCustomers(@PathVariable int customerId) {
        return customerService.getCustomer(customerId);
    }

    @PostMapping
    public Customer addCustomer(@RequestBody Customer newCustomer) {
        newCustomer.setId(null); // Force insert and not update
        customerService.saveCustomer(newCustomer);
        return newCustomer;
    }

    @PutMapping
    public Customer updateCustomer(@RequestBody Customer customer) {
        // Will update as the ID exists
        customerService.saveCustomer(customer);
        return customer;
    }

    @DeleteMapping("/{customerId}")
    public String deleteCustomer(@PathVariable int customerId) {
        customerService.deleteCustomer(customerId);
        return "Deleted customer with ID " + customerId;
    }
}
