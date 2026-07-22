package com.example.SpringBootPracticeAll.dto;

import java.time.LocalDateTime;

public class ExceptionResponseDTO {

    private LocalDateTime timeStamp;
    private Integer statusCode;
    private String error;
    private String message;
    private  String path;



    public ExceptionResponseDTO(LocalDateTime t, Integer s, String e, String m, String p){
        this.timeStamp=t;
        this.statusCode=s;
        this.error=e;
        this.message=m;
        this.path=p;
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
}
