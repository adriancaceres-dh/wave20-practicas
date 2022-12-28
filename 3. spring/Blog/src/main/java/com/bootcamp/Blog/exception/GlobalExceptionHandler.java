package com.bootcamp.Blog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AlredyExistException.class)
    public ResponseEntity<?> AlredyExistException(AlredyExistException e){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMensajeExceptionDTO());
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> AlredyExistException(NotFoundException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMensajeExceptionDTO());
    }
}
