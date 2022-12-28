package com.bootcamp.blog.config;

import com.bootcamp.blog.dto.BlogExceptionDto;
import com.bootcamp.blog.exception.ExistingIdException;
import com.bootcamp.blog.exception.IdNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(IdNotFoundException.class)
    public ResponseEntity<BlogExceptionDto> idNotFoundException(IdNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getBlogExceptionDto());
    }

    @ExceptionHandler(ExistingIdException.class)
    public ResponseEntity<BlogExceptionDto> existingException(ExistingIdException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getBlogExceptionDto());
    }

}
