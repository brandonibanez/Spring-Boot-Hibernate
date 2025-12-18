package com.brandon.mvcdemo.controller;

import javax.xml.transform.stax.StAXResult;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.brandon.mvcdemo.model.Student;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class DemoController {

    // @GetMapping("/hello")
    // public String sayHello(Model model) {
        
    //     model.addAttribute("date", java.time.LocalDateTime.now());
    //     return "helloworld";

    // }

    @GetMapping("/showForm")
    public String showForm(Model model) {

        Student student = new Student();
        student.setFirstName("John");
        student.setLastName("Doe");
        model.addAttribute("student", student);

        return "helloworld-form";
    }

    // @RequestMapping("/processForm")
    // public String processForm(@RequestParam("userName") String userName, Model model) {

    //     // String userName = request.getParameter("userName");
    //     userName = userName.toUpperCase();
    //     model.addAttribute("message", userName);

    //     return "helloworld";
    // }

    @PostMapping("/processForm")
    public String processForm(@ModelAttribute("student") Student student) {

        System.out.println(student.getFirstName());
        return "helloworld-confirmation";
    }

    

}
