package com.lovetocode.springdemo.coach;

import com.lovetocode.springdemo.fortune.FortuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("footyCoach")
public class FootballCoach implements Coach {

    @Autowired
    @Qualifier("configurableFortuneService")
    private FortuneService fortuneService;

    @Override
    public String getDailyWorkout() {
        return "Lads, it's Tottenham";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
