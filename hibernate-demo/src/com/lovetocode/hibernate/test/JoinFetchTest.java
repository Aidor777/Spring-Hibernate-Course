package com.lovetocode.hibernate.test;

import com.lovetocode.hibernate.entity.Course;
import com.lovetocode.hibernate.entity.Instructor;
import com.lovetocode.hibernate.entity.InstructorDetail;
import org.hibernate.cfg.Configuration;

public class JoinFetchTest {

    public static void main(String[] args) {

        // Build up session factory and open a session
        try (var sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();
             var session = sessionFactory.getCurrentSession()) {

            // Begin transaction
            session.beginTransaction();

            // Get an instructor from DB along with its courses
            int instructorID = 1;

            // Create HQL query using join fetch: will also go fetch courses
            var query = session.createQuery(
                    "select i from Instructor i " +
                    "join fetch i.courses " +
                    "where i.id = :instructorID", Instructor.class);

            // Set param
            query.setParameter("instructorID", instructorID);

            // Get result
            var instructor = query.getSingleResult();
            System.out.println("Instructor: " + instructor);

            // Commit transaction
            session.getTransaction().commit();

            // Close the session
            session.close();
            System.out.println("The Hibernate session has been closed!");
            // Because courses were fetched by the HQL query, this should not fail
            System.out.println("Courses: " + instructor.getCourses());

            System.out.println("Done!");
        }

    }

}
