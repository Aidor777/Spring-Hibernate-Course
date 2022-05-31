package com.lovetocode.springboot.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/")
public class FunController {

    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    @GetMapping
    public String sayHello() {
        return "Hello World! Time on server is " + LocalDateTime.now();
    }

    @GetMapping("/workout")
    public String workOut() {
        return "Run a hard 5k";
    }

    @GetMapping("/fortune")
    public String dailyFortune() {
        return "Today is your lucky day";
    }

    @GetMapping("/teamInfo")
    public String teamInfo() {
        return "Coach: " + coachName + ", Team: " + teamName;
    }
}
