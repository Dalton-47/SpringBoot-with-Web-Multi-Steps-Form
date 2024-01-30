package com.example.SpringbootWeb.model;

public class StudentForm {
    private String email;
    private String password;
    private String confirmPassword;

    // Constructor, getters, and setters
    // You might need additional constructors and methods depending on your requirements

    public StudentForm() {
    }

    public StudentForm(String email, String password, String confirmPassword) {
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    // Getters and setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

