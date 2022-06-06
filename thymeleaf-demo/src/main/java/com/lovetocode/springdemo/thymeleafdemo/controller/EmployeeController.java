package com.lovetocode.springdemo.thymeleafdemo.controller;

import com.lovetocode.springdemo.thymeleafdemo.entity.Employee;
import com.lovetocode.springdemo.thymeleafdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    /*private static final List<Employee> EMPLOYEES = List.of(
            new Employee(1, "Leslie", "Andrews", "leslie@lovetocode.com"),
            new Employee(2, "Emma", "Baumgarten", "emma@lovetocode.com"),
            new Employee(3, "Avani", "Gupta", "avani@lovetocode.com"));*/

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public String listEmployees(Model model) {
        model.addAttribute("employees", employeeService.getAll());
        return "employees/employees-list";
    }

    @GetMapping("/addForm")
    public String addEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "employees/employee-form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        if (employee.getId() > 0) {
            employeeService.update(employee);
        } else {
            employeeService.save(employee);
        }
        return "redirect:/employees/list";
    }

    @GetMapping("/updateForm")
    public String updateEmployeeForm(@RequestParam("employeeId") int employeeId, Model model) {
        var employeeToUpdate = employeeService.getById(employeeId);
        model.addAttribute("employee", employeeToUpdate);
        return "employees/employee-form";
    }

    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam("employeeId") int employeeId) {
        employeeService.deleteById(employeeId);
        return "redirect:/employees/list";
    }

    @GetMapping("/search")
    public String searchEmployees(Model model, @RequestParam("name") String name) {
        model.addAttribute("employees", employeeService.searchByName(name));
        return "employees/employees-list";
    }
}
