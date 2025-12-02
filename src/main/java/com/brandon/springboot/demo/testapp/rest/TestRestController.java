package com.brandon.springboot.demo.testapp.rest;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class TestRestController {

    @Value("${coach.name}")
    private String coachName;
    
    @GetMapping("")
    public String sayHello() {
        return coachName;
    }
}