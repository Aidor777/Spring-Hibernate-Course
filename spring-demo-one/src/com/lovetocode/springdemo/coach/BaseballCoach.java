package com.lovetocode.springdemo.coach;

import com.lovetocode.springdemo.fortune.FortuneService;

public class BaseballCoach implements Coach {

    // Private field for our dependency
    private FortuneService fortuneService;

    // Constructor for dependency injection
    public BaseballCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Spend 30 minutes on batting practice";
    }

    @Override
    public String getDailyFortune() {
        return this.fortuneService.getFortune();
    }
}
