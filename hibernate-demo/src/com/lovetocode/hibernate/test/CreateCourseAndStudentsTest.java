package com.lovetocode.hibernate.test;

import com.lovetocode.hibernate.entity.*;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndStudentsTest {

    public static void main(String[] args) {

        // Build up session factory and open a session
        try (var sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class).buildSessionFactory();
             var session = sessionFactory.getCurrentSession()) {

            // Begin transaction
            session.beginTransaction();

            // Create a course and save it
            var course = new Course("Pac-Man - How to score one million points");
            System.out.println("\nSaving course...");
            session.save(course);
            System.out.println("Saved course: " + course);

            // Create students and add them to the course
            var student1 = new Student("John", "Doe", "john@lovetocode.com");
            var student2 = new Student("Mary", "Public", "mary@lovetocode.com");
            course.addStudents(student1, student2);

            // Save the students, should register entries in the join table
            System.out.println("\nSaving students...");
            session.save(student1);
            session.save(student2);
            System.out.println("Saved students: " + course.getStudents());

            // Commit transaction
            session.getTransaction().commit();
            System.out.println("Done!");
        }

    }

}
