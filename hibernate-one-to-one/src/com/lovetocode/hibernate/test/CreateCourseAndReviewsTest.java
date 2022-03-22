package com.lovetocode.hibernate.test;

import com.lovetocode.hibernate.entity.Course;
import com.lovetocode.hibernate.entity.Instructor;
import com.lovetocode.hibernate.entity.InstructorDetail;
import com.lovetocode.hibernate.entity.Review;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndReviewsTest {

    public static void main(String[] args) {

        // Build up session factory and open a session
        try (var sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).addAnnotatedClass(Review.class)
                .buildSessionFactory();
             var session = sessionFactory.getCurrentSession()) {

            // Begin transaction
            session.beginTransaction();

            // Create a course and add some reviews to it
            var course = new Course("Pac-Man - How to score one million points");
            course.addReviews(
                    new Review("Great course... loved it!"),
                    new Review("Cool course, job well done"),
                    new Review("What a dumb course, you are an idiot!"));

            // Save the course... and reviews, leveraging CascadeType.ALL
            System.out.println("Saving course: " + course);
            System.out.println("And reviews: " + course.getReviews());
            session.save(course);

            // Commit transaction
            session.getTransaction().commit();
            System.out.println("Done!");
        }

    }

}
