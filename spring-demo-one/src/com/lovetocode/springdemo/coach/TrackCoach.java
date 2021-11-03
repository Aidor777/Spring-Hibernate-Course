package com.lovetocode.springdemo.coach;

import com.lovetocode.springdemo.fortune.FortuneService;
import org.springframework.beans.factory.DisposableBean;

public class TrackCoach implements Coach, DisposableBean {

    private FortuneService fortuneService;

    public TrackCoach() {
    }

    public TrackCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Run a hard 5k";
    }

    @Override
    public String getDailyFortune() {
        return "Just do it: " + this.fortuneService.getFortune();
    }

    // Will be called on singleton beans even if no destroy-method was provided in the XML config
    @Override
    public void destroy() throws Exception {
        tearDown();
    }

    public void setUp() {
        System.out.println("TrackCoach: inside method setUp");
    }

    public void tearDown() {
        System.out.println("TrackCoach: inside method tearDown");
    }
}
