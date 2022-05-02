package com.example.restfulcalendar.exceptions;

public class AllocatedTimeException extends RuntimeException{

    public AllocatedTimeException(Long id){

        super("This time is already taken");
    }
}
