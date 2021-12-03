package com.lovetocode.springdemo.mvc.controller;

import com.lovetocode.springdemo.mvc.dto.Customer;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @RequestMapping("/showForm")
    public String showForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer-form";
    }

    @RequestMapping("/processForm")
    public String processForm(@Valid @ModelAttribute Customer customer, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "customer-form";
        }
        return "customer-confirmation";
    }

    // Register an init binder
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        // Will trim and consider empty as null
        var stringTrimmerEditor = new StringTrimmerEditor(true);
        // Make it work for all strings
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }
}
