package com.lovetocode.springdemo.config;

import com.lovetocode.springdemo.coach.Coach;
import com.lovetocode.springdemo.coach.SwimCoach;
import com.lovetocode.springdemo.fortune.FortuneService;
import com.lovetocode.springdemo.fortune.SadFortuneService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.lovetocode.springdemo")
@PropertySource({"classpath:sports.properties", "classpath:fortunes.properties"})
public class SportsConfiguration {

    @Bean
    public FortuneService sadFortuneService() {
        return new SadFortuneService();
    }

    @Bean
    public Coach swimCoach() {
        return new SwimCoach(sadFortuneService());
    }
}
