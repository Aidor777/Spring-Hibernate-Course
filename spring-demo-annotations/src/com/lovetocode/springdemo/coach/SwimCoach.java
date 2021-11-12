package com.lovetocode.springdemo.coach;

import com.lovetocode.springdemo.fortune.FortuneService;
import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach {

    private FortuneService fortuneService;

    @Value("${foo.team}")
    private String team;

    @Value("${foo.email}")
    private String email;

    public SwimCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    public String getTeam() {
        return team;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String getDailyWorkout() {
        return "Swim 1000 meters as a warm-up.";
    }

    @Override
    public String getDailyFortune() {
        return this.fortuneService.getFortune();
    }
}
