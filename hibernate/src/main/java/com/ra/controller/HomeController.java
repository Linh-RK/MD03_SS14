package com.ra.controller;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Controller
public class HomeController {
    @RequestMapping("")
    public String home(Model model) {
        String fullName = "Linh Linh";
        model.addAttribute("fullName", fullName);
        return "home";
    }
}
