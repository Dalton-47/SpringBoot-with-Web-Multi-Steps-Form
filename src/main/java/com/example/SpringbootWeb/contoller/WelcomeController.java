package com.example.SpringbootWeb.contoller;

import com.example.SpringbootWeb.model.CourseForm;
import com.example.SpringbootWeb.model.StudentForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@Slf4j
public class WelcomeController {
    @GetMapping("/")
    public String showHome(Model model) {

        StudentForm studentForm = new StudentForm();
        model.addAttribute("studentForm", studentForm);

        CourseForm courseForm = new CourseForm();
        model.addAttribute("courseForm", courseForm);
        return "home";
    }



    @PostMapping("/process-form")
    public String processHome(Model model,
                              @ModelAttribute("studentForm") StudentForm studentForm,
                              @ModelAttribute("courseForm") CourseForm courseForm,
                              @RequestParam("formType") String formType) {

        switch (formType) {
            case "form1":
                // Handle form 1 data
                log.info("Email from form 1: {}", studentForm.getEmail());
                // Add logic to process form 1 data and update model attributes if needed
                break;
            case "form2":
                // Handle form 2 data
                log.info("Course name from form 2: {}", courseForm.getCourseName());
                // Add logic to process form 2 data and update model attributes if needed
                break;
            case "form3":
                // Handle form 3 data
                // Add logic to process form 3 data and update model attributes if needed
                break;
            default:
                // Handle unknown form type
                break;
        }

        // Perform any additional processing if needed

        return "home"; // Return the name of your Thymeleaf view

    }


/*
    @PostMapping("/process-form-2")
    public String processForm2(Model model, @RequestParam("courseName") String courseName) {

        log.info("courseName : {}",courseName);
        return "home";
    }

 */
/*
    @PostMapping("/process-form-2")
    public ResponseEntity<Void> processForm2() {
        // Handle form 2 data processing here
        // No need to return anything since JavaScript handles UI
        return ResponseEntity.ok().build();
    }

 */
}