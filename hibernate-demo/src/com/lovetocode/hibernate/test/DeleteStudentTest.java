package com.lovetocode.hibernate.test;

import com.lovetocode.hibernate.entity.*;
import org.hibernate.cfg.Configuration;

public class DeleteStudentTest {

    public static void main(String[] args) {

        // Build up session factory and open a session
        try (var sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class).buildSessionFactory();
             var session = sessionFactory.getCurrentSession()) {

            // Begin transaction
            session.beginTransaction();

            // Get a student and delete it
            int studentID = 2;
            var student = session.get(Student.class, studentID);
            System.out.println("Got student: " + student);
            System.out.println("With courses: " + student.getCourses());
            System.out.println("Deleting student...");
            session.delete(student);

            // Commit transaction
            session.getTransaction().commit();
            System.out.println("Done!");
        }

    }

}
