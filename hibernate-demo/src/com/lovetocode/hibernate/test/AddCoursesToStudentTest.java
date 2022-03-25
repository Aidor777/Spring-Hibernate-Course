package com.lovetocode.hibernate.test;

import com.lovetocode.hibernate.entity.*;
import org.hibernate.cfg.Configuration;

public class AddCoursesToStudentTest {

    public static void main(String[] args) {

        // Build up session factory and open a session
        try (var sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class).buildSessionFactory();
             var session = sessionFactory.getCurrentSession()) {

            // Begin transaction
            session.beginTransaction();

            // Get a student from DB
            var studentID = 2;
            var student = session.get(Student.class, studentID);
            System.out.println("\nGot student: " + student);
            System.out.println("With courses: " + student.getCourses());

            // Create more courses and add the student to them
            var course1 = new Course("Rubik's Cube - How to Speed Cube");
            var course2 = new Course("Atari 2600 - Game Development");
            course1.addStudents(student);
            course2.addStudents(student);

            // Save the courses
            System.out.println("\nSaving courses...");
            session.save(course1);
            session.save(course2);

            // Commit transaction
            session.getTransaction().commit();
            System.out.println("Done!");
        }

    }

}
