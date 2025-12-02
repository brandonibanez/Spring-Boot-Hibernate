package com.brandon.springboot.demo.testapp.rest;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class TestRestController {
    
    @GetMapping("")
    public String sayHello() {
        return "Hello World";
    }
}