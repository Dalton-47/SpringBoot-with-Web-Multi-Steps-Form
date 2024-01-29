package com.example.SpringbootWeb.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {
    @GetMapping("/")
    public String showHome() {
        return "home";
    }
}