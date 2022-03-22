package com.lovetocode.hibernate.test;

import com.lovetocode.hibernate.entity.Instructor;
import com.lovetocode.hibernate.entity.InstructorDetail;
import org.hibernate.cfg.Configuration;

public class CreateTest {

    public static void main(String[] args) {

        // Build up session factory
        try (var sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class).buildSessionFactory()) {

            // Open session
            var session = sessionFactory.getCurrentSession();

            // Create and associate objects
            var instructor = new Instructor("Chad", "Darby", "darby@lovetocode.com");
            var instructorDetail = new InstructorDetail("http://www.luv2code.com/youtube", "Coding!");
            // var instructor = new Instructor("Madhu", "Patel", "patel@lovetocode.com");
            // var instructorDetail = new InstructorDetail("http://www.youtube.com", "Guitar");
            instructor.setInstructorDetail(instructorDetail);

            // Begin transaction
            session.beginTransaction();

            // Save the instructor: will also save the detail because we specified CascadeType.ALL
            System.out.println("Saving the instructor: " + instructor);
            session.save(instructor);

            // Commit transaction
            session.getTransaction().commit();
            System.out.println("Done!");
        }

    }

}
