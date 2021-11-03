package com.lovetocode.springdemo;

import com.lovetocode.springdemo.coach.Coach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

    public static void main(String[] args) {
        // Load the Spring configuration file
        var context = new ClassPathXmlApplicationContext("applicationContext-beanScope.xml");

        // Retrieve the beans from the Spring container
        var coach = context.getBean("myCoach", Coach.class);
        var alphaCoach = context.getBean("myCoach", Coach.class);

        // Same address in memory ?
        boolean result = coach == alphaCoach;
        System.out.println("\nPointing to the same object: " + result);
        System.out.println("\nMemory location of coach " + coach);
        System.out.println("\nMemory location of alphaCoach: " + alphaCoach + '\n');

        // Close the context
        context.close();
    }
}
