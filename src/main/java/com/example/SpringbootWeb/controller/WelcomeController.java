package com.example.SpringbootWeb.controller;

import com.example.SpringbootWeb.implementation.StudentsImplementation;
import com.example.SpringbootWeb.model.CourseForm;
import com.example.SpringbootWeb.model.SemesterForm;
import com.example.SpringbootWeb.model.StudentForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@Controller
@RequestMapping({"/api"})
@Slf4j
public class WelcomeController {

    @Autowired
    StudentsImplementation studentsImplementation;

    public WelcomeController()
    {

    }
    @GetMapping("/get")
    public String showHome(Model model) {

        StudentForm studentForm = new StudentForm();
        model.addAttribute("studentForm", studentForm);

        log.info("Form One show: {}","This is Form 1");

        return "form1";
    }



    @PostMapping("/process-form")
    public String processForm(Model model,
                              @RequestParam("file") MultipartFile file,
                           //   @RequestParam("formType") String formType,
                              @ModelAttribute("studentForm") StudentForm studentForm,
                              @ModelAttribute("courseForm") CourseForm courseForm)
                              //@ModelAttribute("semesterForm") SemesterForm semesterForm)
                              {

                                  try {
                                      log.info("Form link from form 1: {}", studentForm.getFile().getOriginalFilename());
                                      studentsImplementation.processExcelFile(model, file);
                                   //  return "redirect:form2";
                                      return "form1";
                                        } catch (IOException e) {
                                      e.printStackTrace();
                                      log.info("ERROR form 1: {}", e.getMessage());

                                      //  return "redirect:/error";
                                      return "form1";
                                  }

    }

    @GetMapping("/form2")
    public String showPage2(Model model) {
        CourseForm courseForm = new CourseForm();
        model.addAttribute("courseForm", courseForm);
        log.info("Form Two show: {}","This is Form 2");
        return "form2";
    }

    @PostMapping("/process-form-two")
    public String processForm(Model model,
                              @ModelAttribute("courseForm") CourseForm courseForm,
                              @ModelAttribute("semesterForm") SemesterForm semesterForm)
    {
        // Handle form 2 data
        log.info("Course name from form 2: {}", courseForm.getCourseName());
        return "redirect:/api/form3";
    }

    @GetMapping("/form3")
    public String showPage3(Model model) {
        SemesterForm semesterForm = new SemesterForm();
        model.addAttribute("semesterForm", semesterForm);
        log.info("Form Three show: {}","This is Form 3");
        return "form3";
    }

    @PostMapping("/process-form-three")
    public String processForm(Model model,
                              @ModelAttribute("semesterForm") SemesterForm semesterForm)
    {

        // Handle form 2 data
        log.info("Course name from form 3: {}", semesterForm.getSemesterName());
        return "form3";
    }


}