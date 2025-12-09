package com.brandon.restdemo.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brandon.restdemo.entity.Student;

import jakarta.annotation.PostConstruct;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api")
public class DemoRestController {

    private List<Student> theStudents;

    @RequestMapping("/hello")
    public String sayHello() {
        return "Hello World!";
    }

    @PostConstruct
    public void loadData() {
        theStudents = new ArrayList<>();
        theStudents.add(new Student("Brandon", "Smith"));
        theStudents.add(new Student("Mary", "Public"));
        theStudents.add(new Student("Bonnie", "Apple"));
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return theStudents;
    }

    @GetMapping("/students/{index}")
    public Student getStudent(@PathVariable int index) {

        if (index < 0 || index >= theStudents.size()) {
            throw new StudentNotFoundException("Student index not found - " + index);
        }

        return theStudents.get(index);
    }

}
