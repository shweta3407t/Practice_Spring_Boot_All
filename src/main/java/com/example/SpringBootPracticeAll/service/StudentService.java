package com.example.SpringBootPracticeAll.service;

import com.example.SpringBootPracticeAll.dto.CreateRequestDTO;
import com.example.SpringBootPracticeAll.dto.CreateResponseDTO;
import com.example.SpringBootPracticeAll.dto.UpdateRequestDTO;
import com.example.SpringBootPracticeAll.dto.UpdateResponseDTO;
import com.example.SpringBootPracticeAll.entity.Student;
import com.example.SpringBootPracticeAll.repository.StudentRepository;
import org.springframework.http.ResponseEntity;
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
        Student student=studentRepository. findById(id) ;

        return   mapToDTO(student);
    }

    public List<Student >  getAllStudent(){
        List<Student> studentList=studentRepository.findAll();

        return  studentList;
    }

    public UpdateResponseDTO updateOneStudent(Long id , UpdateRequestDTO student){
           UpdateResponseDTO oldStudent=studentRepository.findByIdAndDeletedFalse(id);


           oldStudent.setName(student.getName());
           oldStudent.setAge(student.getAge());
           oldStudent.setCourse(student.getCourse());
           oldStudent.setRollNo(student.getRollNo());

           oldStudent.setDeleted(false);
           oldStudent.setUpdatedAt(LocalDateTime.now());


           Student studentRes= studentRepository.save( oldStudent);

           return mapToUpdatedDTO(studentRes);

    }

    public   void deleteOneStudent(Long id){
        studentRepository.delete(id);

    }

    public  void  deleteAllStudent(){
        studentRepository.deleteAll();
    }


    public void softDeleteOneStudent(Long id){
        Student student=studentRepository.findByIdAndDeletedFalse(id);

        student.setDeleted(true);

        studentRepository.save(student);
    }

    public Boolean softDeleteAllStudent( ) {

        List<Student> list = studentRepository.findByDeletedFalse();

        for (Student s : list) {
            s.setDeleted(true);
        }
        return true;

    }


    public  Student mapToEntity(CreateRequestDTO  studentReq){
        Student student=new Student();

        student.setName(studentReq.getName());
        student.setAge(studentReq.getAge());
        student.setCourse(studentReq.getCourse());
        student.setEmail(studentReq.getEmail());
        student.setRollNo(studentReq.getRollNo());



        return student;
    }

    public  CreateResponseDTO mapToDTO(Student student){

        CreateResponseDTO responseDTO=new CreateResponseDTO();

        responseDTO.setRollNo(student.getRollNo());
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

    public UpdateResponseDTO mapToUpdatedDTO(Student student){
        UpdateResponseDTO responseDTO=new UpdateResponseDTO();

        responseDTO.setRollNo(student.getRollNo());
        responseDTO.setId(student.getId());
        responseDTO.setName(student.getName());
        responseDTO.setAge(student.getAge());
        responseDTO.setCourse(student.getCourse());
        responseDTO.setEmail(student.getEmail());
        responseDTO.setDeleted(false);

         responseDTO.setUpdatedAt(LocalDateTime .now());

        return  responseDTO;
    }


}
