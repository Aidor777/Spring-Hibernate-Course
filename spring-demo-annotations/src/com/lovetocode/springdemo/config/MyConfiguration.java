package com.lovetocode.springdemo.config;

import com.lovetocode.springdemo.coach.Coach;
import com.lovetocode.springdemo.coach.MyCoach;
import com.lovetocode.springdemo.fortune.FortuneService;
import com.lovetocode.springdemo.fortune.MyFortuneService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfiguration {

    @Bean
    public FortuneService myFortuneService() {
        return new MyFortuneService();
    }

    @Bean
    public Coach myCoach() {
        return new MyCoach(myFortuneService());
    }
}
