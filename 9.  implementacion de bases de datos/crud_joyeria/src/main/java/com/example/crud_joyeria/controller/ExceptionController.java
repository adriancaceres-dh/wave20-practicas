package com.example.crud_joyeria.controller;

import com.example.crud_joyeria.dto.MessageDto;
import com.example.crud_joyeria.exceptions.JoyaNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.function.EntityResponse;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(JoyaNotFoundException.class)
    public ResponseEntity<MessageDto> joyaNotFoundException(JoyaNotFoundException e){
        return new ResponseEntity<>(new MessageDto(e.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
