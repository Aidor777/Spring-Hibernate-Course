package com.lovetocode.springdemo;

import com.lovetocode.springdemo.coach.Coach;
import com.lovetocode.springdemo.config.MyConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyDemoApp {

    public static void main(String[] args) {
        // Load the Spring Java configuration
        var context = new AnnotationConfigApplicationContext(MyConfiguration.class);

        // Retrieve the beans from the Spring container
        var myCoach = context.getBean("myCoach", Coach.class);

        // Do the required work on the beans
        System.out.println(myCoach.getDailyWorkout());
        System.out.println(myCoach.getDailyFortune());

        // Close the context
        context.close();
    }
}
