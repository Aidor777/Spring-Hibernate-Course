package com.lovetocode.springdemo;

import com.lovetocode.springdemo.coach.CricketCoach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {

    public static void main(String[] args) {
        // Load the Spring configuration file
        var context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Retrieve the beans from the Spring container
        var cricketCoach = context.getBean("myCricketCoach", CricketCoach.class);

        // Do the required work on the beans
        System.out.println(cricketCoach.getDailyWorkout());
        System.out.println(cricketCoach.getDailyFortune());

        System.out.println(cricketCoach.getEmailAddress());
        System.out.println(cricketCoach.getTeamName());

        // Close the context
        context.close();
    }
}
