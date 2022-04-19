package com.lovetocode.aopdemo;

import com.lovetocode.aopdemo.config.DemoConfig;
import com.lovetocode.aopdemo.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

public class AroundDemoApp {
    
    private static final Logger LOGGER = Logger.getLogger(AroundDemoApp.class.getName());

    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(DemoConfig.class)) {
            var fortuneService = context.getBean(TrafficFortuneService.class);

            LOGGER.info("\nMain program: AroundDemoApp");
//            LOGGER.info("My fortune: " + fortuneService.getFortune());
            LOGGER.info("My fortune: " + fortuneService.getFortune(true));
        }
    }

}
