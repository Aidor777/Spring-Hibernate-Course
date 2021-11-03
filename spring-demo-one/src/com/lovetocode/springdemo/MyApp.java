package com.lovetocode.springdemo;

import com.lovetocode.springdemo.coach.Coach;
import com.lovetocode.springdemo.coach.TrackCoach;

public class MyApp {

    public static void main(String[] args) {
        Coach coach = new TrackCoach();
        System.out.println(coach.getDailyWorkout());
    }
}
