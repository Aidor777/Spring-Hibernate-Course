package com.lovetocode.springdemo.fortune;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
public class RandomFortuneService implements FortuneService {

    private static final List<String> FORTUNES = List.of(
            "Bad luck is just around the corner!",
            "Might as well play the lottery!",
            "Nothing special...");

    @Override
    public String getFortune() {
        var randomIndex = new Random().nextInt(FORTUNES.size());
        return FORTUNES.get(randomIndex);
    }
}
