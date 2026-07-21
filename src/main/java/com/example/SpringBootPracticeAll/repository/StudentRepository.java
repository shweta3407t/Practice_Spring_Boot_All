package com.example.SpringBootPracticeAll.repository;

import com.example.SpringBootPracticeAll.dto.UpdateRequestDTO;
import com.example.SpringBootPracticeAll.dto.UpdateResponseDTO;
import com.example.SpringBootPracticeAll.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository  extends JpaRepository<Long , Student> {

    UpdateResponseDTO existsByIdAndDeletedFalse(Long id);

    UpdateResponseDTO  findByIdAndDeletedFalse(Long id);

    List<Student>  findByDeletedFalse();

}
