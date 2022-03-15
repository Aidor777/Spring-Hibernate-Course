package com.lovetocode.hibernate.test;

import com.lovetocode.hibernate.entity.Student;
import org.hibernate.cfg.Configuration;

import java.time.LocalDateTime;

public class CreateStudentTest {

    public static void main(String[] args) {
        // Create session factory
        var sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // Create session
        var session = sessionFactory.getCurrentSession();

        try {
            // Create a student object
            System.out.println("Creating a new student object");
            var student = new Student("Paul", "Wall", "paul@lovetocode.com", LocalDateTime.of(1990, 1, 1, 10, 11, 12));

            // Begin a transaction
            session.beginTransaction();

            // Save the student object to database
            System.out.println("Saving the student");
            session.save(student);

            // Commit the transaction
            session.getTransaction().commit();
            System.out.println("Done!");

        } finally {
            sessionFactory.close();
        }
    }
}
