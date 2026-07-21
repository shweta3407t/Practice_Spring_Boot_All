package com.example.SpringBootPracticeAll.service;

import com.example.SpringBootPracticeAll.dto.CreateRequestDTO;
import com.example.SpringBootPracticeAll.dto.CreateResponseDTO;
import com.example.SpringBootPracticeAll.entity.Student;
import com.example.SpringBootPracticeAll.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
public class StudentService {

    StudentRepository studentRepository;

    StudentService(StudentRepository s){
        this.studentRepository=s;
    }

    public CreateResponseDTO createStudent(CreateRequestDTO studentReq){

         Student student=mapToEntity(studentReq);


         CreateResponseDTO studentResponse=mapToDTO(student);

         return studentResponse;


    }

    public CreateResponseDTO getOneStudent(Long id){
        Optional<CreateResponseDTO> student=studentRepository.findById(id);

        return   mapToDTO(student);
    }

    public List<Student >  getAllStudent(){
        List<Student> studentList=studentRepository.findAll();

        return  studentList;
    }

    public  Student mapToEntity(CreateRequestDTO  studentReq){
        Student student=new Student();

        student.setName(studentReq.getName());
        student.setAge(studentReq.getAge());
        student.setCourse(studentReq.getCourse());
        student.setEmail(studentReq.getEmail());


        return student;
    }

    public  CreateResponseDTO mapToDTO(Student student){

        CreateResponseDTO responseDTO=new CreateResponseDTO();

        responseDTO.setId(student.getId());
        responseDTO.setName(student.getName());
        responseDTO.setAge(student.getAge());
        responseDTO.setCourse(student.getCourse());
        responseDTO.setEmail(student.getEmail());
        responseDTO.setDeleted(false);

        responseDTO.setCreatedAt(LocalDateTime.now());
        responseDTO.setUpdatedAt(LocalDateTime .now());

        return  responseDTO;
    }



}
