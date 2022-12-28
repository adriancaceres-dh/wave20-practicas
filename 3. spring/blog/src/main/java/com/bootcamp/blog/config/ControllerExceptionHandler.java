package com.bootcamp.blog.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bootcamp.blog.dto.IdNotFoundResponseDto;
import com.bootcamp.blog.exception.IdNotFoundException;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(IdNotFoundException.class)
    public ResponseEntity<IdNotFoundResponseDto> sintomaNoEncontrado(IdNotFoundException e) {
        return new ResponseEntity<>(e.getIdNotFound(), HttpStatus.NOT_FOUND);
    }

}