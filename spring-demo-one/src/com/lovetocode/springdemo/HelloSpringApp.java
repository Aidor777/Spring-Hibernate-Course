package com.lovetocode.springdemo;

import com.lovetocode.springdemo.coach.Coach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

    public static void main(String[] args) {
        // Load the Spring configuration file
        var context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Retrieve the beans from the Spring container
        var coach = context.getBean("myCoach", Coach.class);
        var customCoach = context.getBean("myCustomCoach", Coach.class);
        var otherCustomCoach = context.getBean("myCustomCoach", Coach.class);

        // Do the required work on the beans
        System.out.println(coach.getDailyWorkout());
        System.out.println(coach.getDailyFortune());
        System.out.println();

        System.out.println(customCoach.getDailyWorkout());
        System.out.println(customCoach.getDailyFortune());
        System.out.println();

        System.out.println("The two myCustomCoach bean instances are the same: " + (customCoach == otherCustomCoach));
        System.out.println();

        // Close the context
        context.close();
    }
}
