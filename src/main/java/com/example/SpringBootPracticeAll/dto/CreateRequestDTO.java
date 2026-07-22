package com.example.SpringBootPracticeAll.dto;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class CreateRequestDTO {
    @NotBlank(message = "name should not be null/empty or blank")
     private  String name;

    @NotBlank(message = "name should not be null/empty or blank")
    @Min(10) @Max(value = 50 ,message = "Age should be between 10 -50 years old")
    private Integer age;

    @NotBlank(message = "name should not be null/empty or blank")
    @Email
    private  String email;

    @NotBlank(message = "name should not be null/empty or blank")
    private String course;

    @NotBlank(message = "name should not be null/empty or blank")
    private  Integer rollNo;


    public Integer getRollNo() {
        return rollNo;
    }

    public void setRollNo(Integer rollNo) {
        this.rollNo = rollNo;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

}


