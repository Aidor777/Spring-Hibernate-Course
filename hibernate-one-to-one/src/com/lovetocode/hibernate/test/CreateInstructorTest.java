package com.lovetocode.hibernate.test;

import com.lovetocode.hibernate.entity.Course;
import com.lovetocode.hibernate.entity.Instructor;
import com.lovetocode.hibernate.entity.InstructorDetail;
import org.hibernate.cfg.Configuration;

public class CreateInstructorTest {

    public static void main(String[] args) {

        // Build up session factory and open a session
        try (var sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();
             var session = sessionFactory.getCurrentSession()) {

            // Create and associate objects
            var instructor = new Instructor("Mary", "Public", "mary.public@lovetocode.com");
            var instructorDetail = new InstructorDetail("http://www.youtube.com", "Video games");
            instructor.setInstructorDetail(instructorDetail);

            // Begin transaction
            session.beginTransaction();
            System.out.println("Saving the instructor: " + instructor);
            session.save(instructor);

            // Commit transaction
            session.getTransaction().commit();
            System.out.println("Done!");
        }

    }

}
