package com.lovetocode.springdemo.fortune;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class HappyFortuneService implements FortuneService{

    @Override
    public String getFortune() {
        return "Today is your lucky day!";
    }

    @PostConstruct
    public void doOnStartup() {
        System.out.println(">> HappyFortuneService: inside doOnStartup()");
    }

    @PreDestroy
    public void doOnDestroy() {
        System.out.println(">> HappyFortuneService: inside doOnDestroy()");
    }
}
