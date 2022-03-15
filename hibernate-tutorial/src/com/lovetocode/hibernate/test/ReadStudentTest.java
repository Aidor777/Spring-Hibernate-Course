package com.lovetocode.hibernate.test;

import com.lovetocode.hibernate.entity.Student;
import org.hibernate.cfg.Configuration;

import java.time.LocalDateTime;

public class ReadStudentTest {

    public static void main(String[] args) {

        // Create session factory and let try-with-resources close it in the end
        try (var sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
                .buildSessionFactory()) {
            // Create session
            var session = sessionFactory.getCurrentSession();
            // Create a student object
            System.out.println("Creating a new student object");
            var student = new Student("Daffy", "Duck", "daffy@lovetocode.com", LocalDateTime.of(1950, 11, 11, 4, 5, 6));

            // Begin a transaction
            session.beginTransaction();

            // Save the student object to database
            System.out.println("Saving the student");
            System.out.println(student);
            session.save(student);

            // Commit the transaction
            session.getTransaction().commit();

            // Find out the student's ID (primary key)
            System.out.println("Student saved, generated ID: " + student.getId());

            // Get a new session and begin a new transaction (even for reading !)
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            // Retrieve the student based on it's ID (primary key)
            System.out.println("\nGetting the student with ID " + student.getId());
            var selectedStudent = session.get(Student.class, student.getId());
            System.out.println("Get complete: " + selectedStudent);

            // Commit the transaction (even for reading !)
            session.getTransaction().commit();

            System.out.println("Done!");
        }
    }
}
