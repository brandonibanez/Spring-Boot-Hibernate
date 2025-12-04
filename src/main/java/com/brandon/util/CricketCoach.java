package com.brandon.util;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class CricketCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes!";
    }

    public CricketCoach() {
        System.out.println(">> CricketCoach: inside default constructor");
    }

    @PostConstruct
    public void doMyStartupStuff() {
        System.out.println(">> CricketCoach: inside of doMyStartupStuff()");
    }

    @PreDestroy
    public void doMyCleanupStuff() {
        System.out.println(">> CricketCoach: inside of doMyCleanupStuff()");
    }

}
