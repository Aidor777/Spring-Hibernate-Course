package com.lovetocode.hibernate.test;

import com.lovetocode.hibernate.entity.Course;
import com.lovetocode.hibernate.entity.Instructor;
import com.lovetocode.hibernate.entity.InstructorDetail;
import org.hibernate.cfg.Configuration;

public class CreateCoursesTest {

    public static void main(String[] args) {

        // Build up session factory and open a session
        try (var sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();
             var session = sessionFactory.getCurrentSession()) {

            // Begin transaction
            session.beginTransaction();

            // Get an instructor from DB
            int instructorID = 1;
            var instructor = session.get(Instructor.class, instructorID);

            // Create courses and add them to the instructor
            var course1 = new Course("Air Guitar - The Ultimate Guide");
            var course2 = new Course("The Pinball Masterclass");
            instructor.addCourses(course1, course2);

            // Save courses
            session.save(course1);
            session.save(course2);

            // Commit transaction
            session.getTransaction().commit();
            System.out.println("Done!");
        }

    }

}
