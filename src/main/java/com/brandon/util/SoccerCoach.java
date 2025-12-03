package com.brandon.util;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class SoccerCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Cristiano Ronaldo: Train for 30 minutes shooting penalties!";
    }

    public SoccerCoach() {
        System.out.println(">> SoccerCoach: inside default constructor");
    }

}
