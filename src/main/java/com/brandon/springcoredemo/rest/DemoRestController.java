package com.brandon.springcoredemo.rest;

import org.springframework.web.bind.annotation.RestController;

import com.brandon.util.Coach;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class DemoRestController {

    private final Coach mCoach;

    public DemoRestController(Coach theCoach) {
        mCoach = theCoach;
    }

    @GetMapping("/test")
    public String getWorkout () {
        return mCoach.getDailyWorkout();
    }

}
