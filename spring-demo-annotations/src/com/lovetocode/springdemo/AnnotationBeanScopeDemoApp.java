package com.lovetocode.springdemo;

import com.lovetocode.springdemo.coach.Coach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

    public static void main(String[] args) {
        // Load the Spring configuration file
        var context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Retrieve the beans from the Spring container
        var coach = context.getBean("tennisCoach", Coach.class);
        var coachTwo = context.getBean("tennisCoach", Coach.class);

        // Do the required work on the beans
        boolean sameObject = coach == coachTwo;

        System.out.println("Both tennisCoach bean references point to the same object: " + sameObject);

        // Close the context
        context.close();
    }
}
