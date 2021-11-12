package com.lovetocode.springdemo;

import com.lovetocode.springdemo.coach.SwimCoach;
import com.lovetocode.springdemo.config.SportsConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigurationDemoApp {

    public static void main(String[] args) {
        // Load the Spring Java configuration
        var context = new AnnotationConfigApplicationContext(SportsConfiguration.class);

        // Retrieve the beans from the Spring container
        var swimCoach = context.getBean("swimCoach", SwimCoach.class);

        // Do the required work on the beans
        System.out.println(swimCoach.getDailyWorkout());
        System.out.println(swimCoach.getDailyFortune());
        System.out.println("Team: " + swimCoach.getTeam());
        System.out.println("Email: " + swimCoach.getEmail());

        // Close the context
        context.close();
    }
}
