package com.lovetocode.hibernate.test;

import com.lovetocode.hibernate.entity.Instructor;
import com.lovetocode.hibernate.entity.InstructorDetail;
import org.hibernate.cfg.Configuration;

public class DeleteInstructorDetailTest {

    public static void main(String[] args) {

        // Build up session factory and open a session
        try (var sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
             var session = sessionFactory.getCurrentSession();) {

            // Begin transaction
            session.beginTransaction();

            // Get an instructor detail by ID
            int instructorDetailID = 3;
            var instructorDetail = session.get(InstructorDetail.class, instructorDetailID);

            System.out.println("Deleting instructor detail: " + instructorDetail);
            // Get rid of any references or Hibernate will complain...
            instructorDetail.getInstructor().setInstructorDetail(null);
            // Should not delete the associated instructor because CascadeType.REMOVE is not given
            session.delete(instructorDetail);

            // Commit transaction
            session.getTransaction().commit();
            System.out.println("Done!");
        }
    }
}
