package com.example.restfulcalendar.exceptions;

public class InvalidDateException extends  RuntimeException{

   public InvalidDateException(Long id){

       super("invalid event start time ");
   }
}
