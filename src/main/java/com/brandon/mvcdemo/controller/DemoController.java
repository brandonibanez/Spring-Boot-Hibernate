package com.brandon.mvcdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController {

    @GetMapping("/hello")
    public String sayHello(Model model) {
        
        model.addAttribute("date", java.time.LocalDateTime.now());
        return "helloworld";

    }

    @RequestMapping("/showForm")
    public String showForm() {
        return "helloworld-form";
    }

    

}
