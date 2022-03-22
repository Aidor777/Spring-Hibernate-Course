package com.lovetocode.hibernate.test;

import com.lovetocode.hibernate.entity.Course;
import com.lovetocode.hibernate.entity.Instructor;
import com.lovetocode.hibernate.entity.InstructorDetail;
import com.lovetocode.hibernate.entity.Review;
import org.hibernate.cfg.Configuration;

public class DeleteCourseAndReviewsTest {

    public static void main(String[] args) {

        // Build up session factory and open a session
        try (var sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).addAnnotatedClass(Review.class)
                .buildSessionFactory();
             var session = sessionFactory.getCurrentSession()) {

            // Begin transaction
            session.beginTransaction();

            // Get a course to delete
            int courseID = 10;
            var course = session.get(Course.class, courseID);
            System.out.println("Deleting course: " + course);
            System.out.println("Along with reviews: " + course.getReviews());

            // Delete the course, will cascade to its reviews as well
            session.delete(course);

            // Commit transaction
            session.getTransaction().commit();
            System.out.println("Done!");
        }

    }

}
