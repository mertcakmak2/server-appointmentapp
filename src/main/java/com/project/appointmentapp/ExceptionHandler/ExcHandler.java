package com.project.appointmentapp.ExceptionHandler;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ExcHandler {

    private String message;
    private String endPoint;

    public ExcHandler() { }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }
}
