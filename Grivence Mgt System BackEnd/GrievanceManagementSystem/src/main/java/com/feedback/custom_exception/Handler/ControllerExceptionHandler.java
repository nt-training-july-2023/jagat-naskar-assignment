package com.feedback.custom_exception.Handler;


import org.springframework.http.HttpStatus;


import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.feedback.custom_exception.DepartmentNotFoundException;
import com.feedback.custom_exception.UserNotFoundException;


@RestControllerAdvice
public class ControllerExceptionHandler {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @org.springframework.web.bind.annotation.ExceptionHandler(DepartmentNotFoundException.class)
    public String departmentNotFoundException(DepartmentNotFoundException ex) {
        return ex.getMessage();
    }
    
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @org.springframework.web.bind.annotation.ExceptionHandler(UserNotFoundException.class)
    public String userNotFoundException(UserNotFoundException ex) {
        return ex.getMessage();
    }

  
}