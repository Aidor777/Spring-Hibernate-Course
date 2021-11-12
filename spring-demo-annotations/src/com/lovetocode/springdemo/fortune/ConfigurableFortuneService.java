package com.lovetocode.springdemo.fortune;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Random;

@Component
public class ConfigurableFortuneService implements FortuneService {

    @Value("#{'${fortunes.list}'.split(',')}")
    private List<String> fortunes;

    @Value("${fortunes.startup.message}")
    private String startupMessage;

    @PostConstruct
    public void init() {
        System.out.println(this.startupMessage);
    }

    @Override
    public String getFortune() {
        var randomIndex = new Random().nextInt(fortunes.size());
        return fortunes.get(randomIndex);
    }
}
