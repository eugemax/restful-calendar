package com.example.restfulcalendar.controller;


import com.example.restfulcalendar.exceptions.AllocatedTimeException;
import com.example.restfulcalendar.exceptions.EventNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


@ControllerAdvice
public class AllocatedTimeAdvice {

    @ResponseBody
    @ExceptionHandler(AllocatedTimeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String AllocatedTimeHandler(AllocatedTimeException ex) {

        return ex.getMessage();
    }


}
