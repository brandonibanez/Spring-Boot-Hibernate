package com.brandon;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.ModelAttribute;


@Controller
public class CustomerController {

    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("customer", new Customer("Brandon", "Browns"));
        return "customer-form";
    }   
    
    @PostMapping("/customers")
    public String processForm(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "customer-form";
        }
        return "customer-confirmation"; 
    }

}
