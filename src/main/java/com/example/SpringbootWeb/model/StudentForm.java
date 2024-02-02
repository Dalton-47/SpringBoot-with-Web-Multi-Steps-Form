package com.example.SpringbootWeb.model;

import org.springframework.web.multipart.MultipartFile;

public class StudentForm {
    private MultipartFile file;
    private String password;
    private String confirmPassword;

    // Constructor, getters, and setters
    // You might need additional constructors and methods depending on your requirements

    public StudentForm() {
    }

    public StudentForm(MultipartFile file, String password, String confirmPassword) {
        this.file = file;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    // Getters and setters
    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}

