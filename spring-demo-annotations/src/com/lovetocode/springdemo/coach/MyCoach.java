package com.lovetocode.springdemo.coach;

import com.lovetocode.springdemo.fortune.FortuneService;

public class MyCoach implements Coach{

    private FortuneService fortuneService;

    public MyCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Stay in bed all day.";
    }

    @Override
    public String getDailyFortune() {
        return this.fortuneService.getFortune();
    }
}
