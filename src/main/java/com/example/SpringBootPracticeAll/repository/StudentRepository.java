package com.example.SpringBootPracticeAll.repository;

import com.example.SpringBootPracticeAll.dto.CreateRequestDTO;
import com.example.SpringBootPracticeAll.dto.CreateResponseDTO;
import com.example.SpringBootPracticeAll.dto.UpdateRequestDTO;
import com.example.SpringBootPracticeAll.dto.UpdateResponseDTO;
import com.example.SpringBootPracticeAll.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository  extends JpaRepository<  Student , Long> {
    Optional<Student> findByIdAndDeletedFalse(Long id);


     List<Student>  findByDeletedFalse();

    Boolean  emailExists(Student s);
}
