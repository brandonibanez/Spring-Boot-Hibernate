package com.brandon.springcoredemo.rest;

import org.springframework.web.bind.annotation.RestController;

import com.brandon.util.Coach;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class DemoRestController {

    private Coach mCoach;

    // public DemoRestController(Coach theCoach) {
    //     mCoach = theCoach;
    // }

    @Autowired
    public void setCoach(@Qualifier("soccerCoach") Coach theCoach) {
        mCoach = theCoach;
    }

    @GetMapping("/test")
    public String getWorkout () {
        return mCoach.getDailyWorkout();
    }

}
