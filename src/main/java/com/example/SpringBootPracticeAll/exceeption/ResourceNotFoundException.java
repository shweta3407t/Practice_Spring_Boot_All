package com.example.SpringBootPracticeAll.exceeption;

public class ResourceNotFoundException extends  RuntimeException {
    public  ResourceNotFoundException(String message){
        super(message);
    }
}
