package com.lovetocode.hibernate.test;

import com.lovetocode.hibernate.entity.Course;
import com.lovetocode.hibernate.entity.Instructor;
import com.lovetocode.hibernate.entity.InstructorDetail;
import org.hibernate.cfg.Configuration;

public class EagerLazyTest {

    public static void main(String[] args) {

        // Build up session factory and open a session
        try (var sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();
             var session = sessionFactory.getCurrentSession()) {

            // Begin transaction
            session.beginTransaction();

            // Get an instructor from DB along with its courses
            int instructorID = 1;
            var instructor = session.get(Instructor.class, instructorID);
            System.out.println("Instructor: " + instructor);
            System.out.println("Courses: " + instructor.getCourses());

            // Commit transaction
            session.getTransaction().commit();

            // Close the session early...
            session.close();
            System.out.println("The Hibernate session has been closed!");
            // Because the session is closed, this should fail if line 24 is commented out ! Courses are loaded lazily
            System.out.println("Courses: " + instructor.getCourses());

            System.out.println("Done!");
        }

    }

}
