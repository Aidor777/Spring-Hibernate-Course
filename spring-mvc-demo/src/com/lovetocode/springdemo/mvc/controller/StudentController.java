package com.lovetocode.springdemo.mvc.controller;

import com.lovetocode.springdemo.mvc.dto.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Value("#{'${programming.languages.options}'.split(',')}")
    private List<String> programmingLanguageOptions;

    @RequestMapping("/showForm")
    public String showForm(Model model) {
        var student = new Student();
        // Add this student to the model
        model.addAttribute("student", student);
        // Also add country options
        model.addAttribute("countryOptions", Student.COUNTRY_OPTIONS);
        // And our programming language options
        model.addAttribute("programmingLanguageOptions", this.programmingLanguageOptions);

        return "student-form";
    }

    @RequestMapping("/processForm")
    public String processForm(@ModelAttribute("student") Student student) {
        System.out.println("Student: " + student.getFirstName() + " " + student.getLastName());
        return "student-confirmation";
    }
}
