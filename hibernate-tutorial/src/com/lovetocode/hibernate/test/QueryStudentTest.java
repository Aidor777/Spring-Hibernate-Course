package com.lovetocode.hibernate.test;

import com.lovetocode.hibernate.entity.Student;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentTest {

    public static void main(String[] args) {

        // Create session factory and let try-with-resources close it in the end
        try (var sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
                .buildSessionFactory()) {
            // Create session
            var session = sessionFactory.getCurrentSession();

            // Begin a transaction
            session.beginTransaction();

            // Query all students
            var queriedStudents = session.createQuery("from Student", Student.class).getResultList();

            // Display the results
            System.out.println("All students:");
            displayStudents(queriedStudents);

            // Query students whose last name is Doe
            queriedStudents = session.createQuery("from Student s where s.lastName = 'Doe'", Student.class).getResultList();

            // Display the results
            System.out.println("Students whose last name is Doe:");
            displayStudents(queriedStudents);

            // Query students whose last name is Doe or first name is Daffy
            queriedStudents = session.createQuery("from Student s where s.lastName = 'Doe' or s.firstName = 'Daffy'", Student.class)
                    .getResultList();

            // Display the results
            System.out.println("Students whose last name is Doe or first name is Daffy:");
            displayStudents(queriedStudents);

            // Query students whose email address ends in lovetocode.com
            queriedStudents = session.createQuery("from Student s where s.email like '%lovetocode.com'", Student.class).getResultList();

            // Display the results
            System.out.println("Students whose ends in lovetocode.com:");
            displayStudents(queriedStudents);

            // Commit the transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        }
    }

    private static void displayStudents(List<Student> students) {
        for (var student : students) {
            System.out.println(student);
        }
        System.out.println();
    }
}
