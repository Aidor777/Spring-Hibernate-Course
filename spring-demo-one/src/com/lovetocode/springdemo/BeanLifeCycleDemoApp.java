package com.lovetocode.springdemo;

import com.lovetocode.springdemo.coach.Coach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleDemoApp {

    public static void main(String[] args) {
        // Load the Spring configuration file
        var context = new ClassPathXmlApplicationContext("applicationContext-beanLifeCycle.xml");

        // Retrieve the beans from the Spring container
        var coach = context.getBean("myCoach", Coach.class);

        // Do the required work on the beans
        System.out.println(coach.getDailyWorkout());
        System.out.println(coach.getDailyFortune());

        // Close the context
        context.close();
    }
}
