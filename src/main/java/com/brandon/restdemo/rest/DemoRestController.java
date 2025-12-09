package com.brandon.restdemo.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brandon.restdemo.entity.Student;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api")
public class DemoRestController {

    @RequestMapping("/hello")
    public String sayHello() {
        return "Hello World!";
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Brandon", "Smith"));
        students.add(new Student("Mary", "Public"));
        return students;
    }
    

}
