package com.lovetocode.spring.crm.client.controller;

import com.lovetocode.spring.crm.client.model.Customer;
import com.lovetocode.spring.crm.client.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public String listCustomers(Model model) {
        var customers = customerService.getCustomers();
        model.addAttribute("customers", customers);
        return "list-customers";
    }

    @GetMapping("/showAddCustomerForm")
    public String showAddCustomerForm(Model model) {
        // Create model attribute to bind form data
        var customer = new Customer();
        model.addAttribute("customer", customer);
        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.saveCustomer(customer);
        return "redirect:/customer/list";
    }

    @GetMapping("/showUpdateCustomerForm")
    public String showUpdateCustomerForm(@RequestParam("customerId") int customerId, Model model) {
        var customer = customerService.getCustomer(customerId);
        model.addAttribute("customer", customer);
        return "customer-form";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("customerId") int customerId) {
        customerService.deleteCustomer(customerId);
        return "redirect:/customer/list";
    }

}
