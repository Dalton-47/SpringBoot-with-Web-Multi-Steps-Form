package com.example.SpringbootWeb.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class SemesterForm {
    private String semesterName;
    private String semesterID;
    private String semesterDetail;

    public String getSemesterName() {
        return semesterName;
    }

    public void setSemesterName(String semesterName) {
        this.semesterName = semesterName;
    }

    public String getSemesterID() {
        return semesterID;
    }

    public void setSemesterID(String semesterID) {
        this.semesterID = semesterID;
    }

    public String getSemesterDetail() {
        return semesterDetail;
    }

    public void setSemesterDetail(String semesterDetail) {
        this.semesterDetail = semesterDetail;
    }
}
