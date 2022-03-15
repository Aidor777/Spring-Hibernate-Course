package com.lovetocode.hibernate.test;

import com.lovetocode.hibernate.entity.Student;
import org.hibernate.cfg.Configuration;

import java.time.LocalDateTime;

public class PrimaryKeyTest {

    public static void main(String[] args) {
        // Create session factory
        var sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // Create session
        var session = sessionFactory.getCurrentSession();

        try {
            // Create 3 student objects
            System.out.println("Creating 3 new student objects");
            var student1 = new Student("John", "Doe", "john@lovetocode.com", LocalDateTime.of(1985, 12, 31, 23, 59, 59));
            var student2 = new Student("Mary", "Public", "mary@lovetocode.com", LocalDateTime.of(1995, 1, 1, 0, 0, 0));
            var student3 = new Student("Bonita", "Applebum", "bonita@lovetocode.com", LocalDateTime.of(2000, 6, 15, 7, 35, 44));

            // Begin a transaction
            session.beginTransaction();

            // Save the student objects to database
            System.out.println("Saving the students");
            session.save(student1);
            session.save(student2);
            session.save(student3);

            // Commit the transaction
            session.getTransaction().commit();
            System.out.println("Done!");

        } finally {
            sessionFactory.close();
        }
    }
}
