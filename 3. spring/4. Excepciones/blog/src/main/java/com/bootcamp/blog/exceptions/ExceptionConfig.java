package com.bootcamp.blog.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionConfig {

    @ExceptionHandler(BlogExistExceptions.class)
    public ResponseEntity<String> blogExistException (Exception e){
        //return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(BlogNotFoundException.class)
    public ResponseEntity<String> blogNotFoundException (Exception e){
        return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
    }
}
