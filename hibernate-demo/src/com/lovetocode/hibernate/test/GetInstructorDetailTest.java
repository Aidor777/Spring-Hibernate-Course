package com.lovetocode.hibernate.test;

import com.lovetocode.hibernate.entity.Instructor;
import com.lovetocode.hibernate.entity.InstructorDetail;
import org.hibernate.cfg.Configuration;

public class GetInstructorDetailTest {

    public static void main(String[] args) {

        // Build up session factory and open a session
        try (var sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
             var session = sessionFactory.getCurrentSession();) {

            // Begin transaction
            session.beginTransaction();

            // Get an instructor detail by ID (should also fetch the instructor)
            int instructorDetailID = 2;
            var instructorDetail = session.get(InstructorDetail.class, instructorDetailID);

            System.out.println("Instructor detail: " + instructorDetail);
            System.out.println("Associated instructor: " + instructorDetail.getInstructor());

            // Commit transaction
            session.getTransaction().commit();
            System.out.println("Done!");
        }
    }
}
