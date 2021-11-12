package com.lovetocode.springdemo;

import com.lovetocode.springdemo.coach.Coach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

    public static void main(String[] args) {
        // Load the Spring configuration file
        var context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Retrieve the beans from the Spring container
        var coach = context.getBean("tennisCoach", Coach.class);
        var footyCoach = context.getBean("footyCoach", Coach.class);

        // Do the required work on the beans
        System.out.println(coach.getDailyWorkout());
        System.out.println(footyCoach.getDailyWorkout());
        System.out.println(coach.getDailyFortune());
        System.out.println(footyCoach.getDailyFortune());

        // Close the context
        context.close();
    }
}
