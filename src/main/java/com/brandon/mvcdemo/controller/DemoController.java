package com.brandon.mvcdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class DemoController {

    // @GetMapping("/hello")
    // public String sayHello(Model model) {
        
    //     model.addAttribute("date", java.time.LocalDateTime.now());
    //     return "helloworld";

    // }

    @RequestMapping("/showForm")
    public String showForm() {
        return "helloworld-form";
    }

    @RequestMapping("/processForm")
    public String processForm(@RequestParam("userName") String userName, Model model) {

        // String userName = request.getParameter("userName");
        userName = userName.toUpperCase();
        model.addAttribute("message", userName);

        return "helloworld";
    }

    

}
