package com.lovetocode.springdemo.fortune;

public class MyFortuneService implements FortuneService {

    @Override
    public String getFortune() {
        return "No luck today.";
    }
}
