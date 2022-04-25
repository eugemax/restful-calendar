package com.example.restfulcalendar.controller;

import com.example.restfulcalendar.exceptions.EventNotFoundException;
import com.example.restfulcalendar.exceptions.InvalidDateRangeException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class InvalidDateRangeAdvice {

    @ResponseBody
    @ExceptionHandler(InvalidDateRangeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String invalidDateRangeHandler(InvalidDateRangeException ex) {

        return ex.getMessage();
    }



}
