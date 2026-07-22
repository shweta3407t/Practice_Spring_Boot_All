package com.example.SpringBootPracticeAll.exceeption;

import com.example.SpringBootPracticeAll.dto.ExceptionResponseDTO;
import com.example.SpringBootPracticeAll.dto.ValidateExceptionResponseDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidateExceptionResponseDTO>  MethodArgumentNotFoundExceptionHandler(
            HttpServletRequest request , MethodArgumentNotValidException e){

        Map<String ,String>  fieldErrors=new HashMap<>();
        e.getBindingResult().getFieldErrors()
                .forEach(error ->
                        fieldErrors.put(error.getField() , error.getDefaultMessage()));


        ValidateExceptionResponseDTO exceptionResponse=new ValidateExceptionResponseDTO(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                HttpStatus.BAD_REQUEST.getReasonPhrase(),
                "Validation failed",
                request.getRequestURI(),
                fieldErrors
        );

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(exceptionResponse);
    }












    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionResponseDTO> runtimeExceptionHandler(
            HttpServletRequest request , RuntimeException e){


          ExceptionResponseDTO exceptionResponse=new ExceptionResponseDTO(
                  LocalDateTime.now(),
                 HttpStatus.INTERNAL_SERVER_ERROR.value(),
                 HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
              "Validation failed",
                 request.getRequestURI());

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(exceptionResponse);

    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponseDTO> genericExceptionHandler(
            HttpServletRequest request , Exception e){


        ExceptionResponseDTO exceptionResponse=new ExceptionResponseDTO(
                LocalDateTime.now(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
                "Validation failed",
                request.getRequestURI());

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(exceptionResponse);

    }






    @ExceptionHandler(DuplicateResourceException.class)
    public ResponseEntity<ExceptionResponseDTO> duplicateResourceExceptionHandler(
            HttpServletRequest request , DuplicateResourceException e){

        ExceptionResponseDTO exceptionResponse=new ExceptionResponseDTO(
                LocalDateTime.now(),
                HttpStatus. CONFLICT.value(),
                HttpStatus.CONFLICT.getReasonPhrase(),
                "Validation failed",
                request.getRequestURI());

        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(exceptionResponse);

    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ExceptionResponseDTO> ResourceNotFoundExceptionHandler(HttpServletRequest request , RuntimeException e){

        ExceptionResponseDTO exceptionResponse=new ExceptionResponseDTO(
                LocalDateTime.now(),
                HttpStatus.CONFLICT.value(),
                HttpStatus.CONFLICT.getReasonPhrase(),
                "Validation failed",
                request.getRequestURI());

        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(exceptionResponse);

    }

}
