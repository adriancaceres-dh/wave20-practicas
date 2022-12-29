package com.bootcamp.blog.config;

import com.bootcamp.blog.dto.MensajeExeptionDto;
import com.bootcamp.blog.exeption.IdExistExeption;
import com.bootcamp.blog.exeption.IdNotFoundExeption;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExeptionConfig {
    @ExceptionHandler(IdExistExeption.class)
    public ResponseEntity<?> idExistExeption(IdExistExeption e){
        return new ResponseEntity<>(e.getMensajeExeptionDto(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(IdNotFoundExeption.class)
    public ResponseEntity<?> idNotFoundExeption(IdNotFoundExeption e){
        return new ResponseEntity<>(e.getMensajeExeptionDto(), HttpStatus.NOT_FOUND);
    }
}
