package com.example.SpringBootPracticeAll.exceeption;

import com.example.SpringBootPracticeAll.dto.ExceptionResponseDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionResponseDTO> globalExceptionHandler(HttpServletRequest request , RuntimeException e){


          ExceptionResponseDTO exceptionResponse=new ExceptionResponseDTO(
             LocalDateTime.now(),
                     HttpStatus.INTERNAL_SERVER_ERROR.value(),
                     HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
                     e.getMessage(),
                     request.getRequestURI());

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(exceptionResponse);

    }

}
