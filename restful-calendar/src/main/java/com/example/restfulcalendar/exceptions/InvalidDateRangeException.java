package com.example.restfulcalendar.exceptions;

public class InvalidDateRangeException extends  RuntimeException{

   public InvalidDateRangeException(Long id){

       super("End of the event must be later than start");
   }
}
