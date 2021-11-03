package com.lovetocode.springdemo.coach;

import com.lovetocode.springdemo.fortune.FortuneService;

public class FootballCoach implements Coach {

    private FortuneService fortuneService;

    public FootballCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Lads, it's Tottenham";
    }

    @Override
    public String getDailyFortune() {
        return this.fortuneService.getFortune();
    }

    public void tearDown() {
        System.out.println("FootballCoach: If this is printed, it means the scope of this bean was NOT prototype");
    }
}
