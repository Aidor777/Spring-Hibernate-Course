package com.lovetocode.hibernate.test;

import com.lovetocode.hibernate.entity.Instructor;
import com.lovetocode.hibernate.entity.InstructorDetail;
import org.hibernate.cfg.Configuration;

public class DeleteTest {

    public static void main(String[] args) {

        // Build up session factory
        try (var sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class).buildSessionFactory()) {

            // Open session
            var session = sessionFactory.getCurrentSession();

            // Begin transaction
            session.beginTransaction();

            // Get an instructor by ID
            int instructorID = 1;
            var instructor = session.get(Instructor.class, instructorID);

            if (instructor != null) {
                System.out.println("Deleting instructor " + instructor);
                // Will also delete the detail because of CascadeType.ALL
                session.delete(instructor);
            }

            // Commit transaction
            session.getTransaction().commit();
            System.out.println("Done!");
        }

    }

}
