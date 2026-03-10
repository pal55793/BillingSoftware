package com.rk.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

	@GetMapping("/")
    public String showIndexPage(Model model) {
        // You can pass dynamic data to your HTML page using the Model
        model.addAttribute("title", "My Spring Boot Demo");
        model.addAttribute("message", "Welcome to the default index page!");
        System.out.println("I am here");
        // This returns the "index.html" file located in the templates folder
        return "Index"; 
    }
}
