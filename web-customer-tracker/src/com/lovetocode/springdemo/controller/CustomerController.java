package com.lovetocode.springdemo.controller;

import com.lovetocode.springdemo.entity.Customer;
import com.lovetocode.springdemo.service.CustomerService;
import com.lovetocode.springdemo.utils.SortColumnEnum;
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
    public String listCustomers(Model model, @RequestParam(value = "sortColumn", required = false) SortColumnEnum sortColumn) {
        var customers = customerService.getCustomers(sortColumn);
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

    @GetMapping("/search")
    public String searchCustomers(@RequestParam("searchName") String searchName, Model model) {
        var customers = customerService.searchCustomers(searchName);
        model.addAttribute("customers", customers);
        return "list-customers";
    }

}
