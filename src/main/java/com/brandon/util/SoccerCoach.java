package com.brandon.util;

import org.springframework.stereotype.Component;

@Component
public class SoccerCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Cristiano Ronaldo: Train for 30 minutes shooting penalties!";
    }

}
