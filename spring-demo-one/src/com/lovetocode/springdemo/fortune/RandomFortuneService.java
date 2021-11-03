package com.lovetocode.springdemo.fortune;

import java.util.List;
import java.util.Random;

public class RandomFortuneService implements FortuneService {

    private static final List<String> FORTUNES = List.of(
            "Bad luck is just around the corner!",
            "Might as well play the lottery!",
            "Nothing special...");

    @Override
    public String getFortune() {
        var fortunesCount = FORTUNES.size();
        var randomIndex = new Random().nextInt(fortunesCount);
        return FORTUNES.get(randomIndex);
    }
}
