package com.example.SpringBootPracticeAll.controller;

import com.example.SpringBootPracticeAll.dto.CreateRequestDTO;
import com.example.SpringBootPracticeAll.dto.CreateResponseDTO;
import com.example.SpringBootPracticeAll.entity.Student;
import com.example.SpringBootPracticeAll.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    StudentService studentService;

    StudentController(StudentService s){
        this.studentService=s;
    }

    @PostMapping
    public ResponseEntity<CreateResponseDTO> createStudent( @Valid  @RequestBody CreateRequestDTO studentReq){
        CreateResponseDTO student=studentService.createStudent(studentReq);

        return ResponseEntity.ok().body(student);
    }

    @GetMapping
    public  ResponseEntity<CreateResponseDTO> getOneStudent(@PathVariable Long id){
        CreateResponseDTO student=studentService.getOneStudent(id);

        return ResponseEntity.ok(student);
    }
}
