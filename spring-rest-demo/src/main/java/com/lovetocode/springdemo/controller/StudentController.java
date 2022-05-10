package com.lovetocode.springdemo.controller;

import com.lovetocode.springdemo.model.StudentNotFoundException;
import com.lovetocode.springdemo.model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final List<Student> students = List.of(
            new Student("Poornima", "Patel"),
            new Student("Mario", "Rossi"),
            new Student("Mary", "Smith"));

    @GetMapping
    public List<Student> getStudents() {
        return students;
    }

    @GetMapping("/{studentId}")
    public Student getStudentById(@PathVariable int studentId) {
        // Keep it simple; match student ID with list index
        if (studentId < 0 || studentId >= students.size()) {
            throw new StudentNotFoundException("Student ID not found: " + studentId);
        }
        return students.get(studentId);
    }

}
