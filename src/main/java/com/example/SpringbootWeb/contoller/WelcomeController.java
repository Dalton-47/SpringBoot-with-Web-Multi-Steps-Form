package com.example.SpringbootWeb.contoller;

import com.example.SpringbootWeb.model.CourseForm;
import com.example.SpringbootWeb.model.SemesterForm;
import com.example.SpringbootWeb.model.StudentForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


@Controller
@Slf4j
public class WelcomeController {
    @GetMapping("/")
    public String showHome(Model model) {

        StudentForm studentForm = new StudentForm();
        model.addAttribute("studentForm", studentForm);
/*
        CourseForm courseForm = new CourseForm();
        model.addAttribute("courseForm", courseForm);

        SemesterForm semesterForm = new SemesterForm();
        model.addAttribute("semesterForm", semesterForm);

 */

        return "form1";
    }



    @PostMapping("process-form")
    public String processForm(Model model,
                              //@RequestParam("file") MultipartFile file,
                              @RequestParam("formType") String formType,
                              @ModelAttribute("studentForm") StudentForm studentForm)
                            //  @ModelAttribute("courseForm") CourseForm courseForm,
                              //@ModelAttribute("semesterForm") SemesterForm semesterForm)
                              {

        // Handle form 1 data
        log.info("Form link from form 1: {}", studentForm.getFile().getOriginalFilename());
        // Add logic to process form 1 data and update model attributes if needed
        return "form2";

    }

    @PostMapping("process-form-2")
    public String processForm(Model model,@ModelAttribute("courseForm") CourseForm courseForm)
    {
        // Handle form 2 data
        log.info("Course name from form 2: {}", courseForm.getCourseName());
        return "form3";
    }

    @PostMapping("process-form-3")
    public String processForm(Model model,@ModelAttribute("semesterForm") SemesterForm semesterForm)
    {
        // Handle form 2 data
        log.info("Course name from form 3: {}", semesterForm.getSemesterName());
        return "form3";
    }


}