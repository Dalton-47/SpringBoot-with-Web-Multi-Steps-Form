package com.example.SpringbootWeb.contoller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
public class WelcomeController {
    @GetMapping("/")
    public String showHome() {
        return "home";
    }

    @PostMapping("process-form")
    public String processHome(Model model, @RequestParam("email") String email) {

        log.info("email : {}",email);
        return "home";
    }

    @PostMapping("process-form-2")
    public String processForm2(Model model, @RequestParam("courseName") String courseName) {

        log.info("courseName : {}",courseName);
        return "home";
    }
}