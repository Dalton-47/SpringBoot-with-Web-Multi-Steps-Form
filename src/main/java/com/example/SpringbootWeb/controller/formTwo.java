package com.example.SpringbootWeb.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class formTwo {
    @PostMapping("/process-form-2")
    public ResponseEntity<Void> processForm2() {
        // Handle form 2 data processing here
        // No need to return anything since JavaScript handles UI
        return ResponseEntity.ok().build();
    }
}
