package com.example.restfulcalendar.controller;

import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ValidationHandler extends ResponseEntityExceptionHandler {

    @Override
    protected @NotNull ResponseEntity<Object>handleMethodArgumentNotValid(MethodArgumentNotValidException exception,
                                                                          @NotNull HttpHeaders headers, @NotNull HttpStatus status, @NotNull WebRequest request){

        Map<String, String> errors= new HashMap<>();

        exception.getBindingResult().getAllErrors().forEach(objectError -> {

            String fieldName=((FieldError)objectError).getField();

            String message= objectError.getDefaultMessage();

            errors.put(fieldName, message);
        });

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
