package com.brandon.springcoredemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


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
