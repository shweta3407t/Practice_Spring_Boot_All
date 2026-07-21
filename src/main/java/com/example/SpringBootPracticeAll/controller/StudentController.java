package com.example.SpringBootPracticeAll.controller;

import com.example.SpringBootPracticeAll.dto.CreateRequestDTO;
import com.example.SpringBootPracticeAll.dto.CreateResponseDTO;
import com.example.SpringBootPracticeAll.dto.UpdateRequestDTO;
import com.example.SpringBootPracticeAll.dto.UpdateResponseDTO;
import com.example.SpringBootPracticeAll.entity.Student;
import com.example.SpringBootPracticeAll.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/{id}")
    public  ResponseEntity<CreateResponseDTO> getOneStudent(@PathVariable Long id){
        CreateResponseDTO student=studentService.getOneStudent(id);

        return ResponseEntity.ok(student);
    }

    @GetMapping
    public  ResponseEntity<List<Student>> getAllStudent(){
        List<Student> student=studentService.getAllStudent();

        return ResponseEntity.ok().body(student );
    }


    @PutMapping("/{id}")
    public  ResponseEntity<UpdateResponseDTO> updateOneStudent(@PathVariable Long id, UpdateRequestDTO studentReq){
        UpdateResponseDTO newStudent=studentService.updateOneStudent(id ,studentReq );

        return ResponseEntity.ok().body(newStudent);

    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<String> deleteOneStudent(@PathVariable Long id){
        studentService.deleteOneStudent(id);

        return ResponseEntity.ok("Student deleted");
    }


    @DeleteMapping
    public  ResponseEntity<String> deleteAllStudent(){
        studentService.deleteAllStudent();
        return ResponseEntity.ok("All Student deleted");
    }
}
