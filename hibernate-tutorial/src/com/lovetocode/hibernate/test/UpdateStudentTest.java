package com.lovetocode.hibernate.test;

import com.lovetocode.hibernate.entity.Student;
import org.hibernate.cfg.Configuration;

public class UpdateStudentTest {

    public static void main(String[] args) {

        // Create session factory and let try-with-resources close it in the end
        try (var sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
                .buildSessionFactory()) {
            // Get a new session and begin a transaction
            var session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            // Retrieve a student based on it's ID (primary key)
            int studentID = 1;
            System.out.println("\nGetting student with ID: " + studentID);
            var student = session.get(Student.class, studentID);

            // Update the student
            System.out.println("\nUpdating the student: " + student);
            student.setFirstName("Scooby");

            // Commit the transaction (will persist updates)
            session.getTransaction().commit();

            // Get a new session and begin a new transaction
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            // Update email for students whose last name is Doe
            System.out.println("\nUpdating email for students whose last name is Doe");
            session.createQuery("update Student s set s.email = 'doe@gmail.com' where s.lastName = 'Doe'").executeUpdate();

            // Commit the transaction (will persist updates)
            session.getTransaction().commit();

            System.out.println("Done!");
        }
    }
}
