package com.lovetocode.springdemo.coach;

import com.lovetocode.springdemo.fortune.FortuneService;

public class CricketCoach implements Coach {

    private String emailAddress;

    private String teamName;

    private FortuneService fortuneService;

    // Used for setter injection
    public void setFortuneService(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes";
    }

    @Override
    public String getDailyFortune() {
        return this.fortuneService.getFortune();
    }
}
