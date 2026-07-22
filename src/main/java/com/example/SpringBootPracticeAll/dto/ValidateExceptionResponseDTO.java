package com.example.SpringBootPracticeAll.dto;

import java.time.LocalDateTime;
import java.util.Map;

public class ValidateExceptionResponseDTO {

    private LocalDateTime timeStamp;
    private  Integer statusCode;
    private  String error;
    private  String message;
    private String path;

    private Map<String ,String> fieldErrors;

    public ValidateExceptionResponseDTO(LocalDateTime timeStamp, Integer statusCode, String error, String message, String path, Map<String, String> fieldError) {
        this.timeStamp = timeStamp;
        this.statusCode = statusCode;
        this.error = error;
        this.message = message;
        this.path = path;
        this.fieldErrors = fieldError;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Map<String, String> getFieldError() {
        return fieldErrors;
    }

    public void setFieldError(Map<String, String> fieldError) {
        this.fieldErrors= fieldError;
    }
}
