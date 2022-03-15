package com.lovetocode.hibernate.test;

import com.lovetocode.hibernate.entity.Student;
import org.hibernate.cfg.Configuration;

public class DeleteStudentTest {

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

            // Delete the student
            System.out.println("\nDeleting the student: " + student);
            session.delete(student);

            // Commit the transaction
            session.getTransaction().commit();

            // Get a new session and begin a new transaction
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            // Delete students whose last name is Duck
            System.out.println("\nDeleting students whose last name is Duck");
            session.createQuery("delete from Student s where s.lastName = 'Duck'").executeUpdate();

            // Commit the transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        }
    }
}
