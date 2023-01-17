package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Map;

@ControllerAdvice
public class BaseController {


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StudentDTO> handleValidationExceptions(MethodArgumentNotValidException ex){

        StudentDTO studentDTO = new StudentDTO("Custom message ", ex.getMessage());
        return new ResponseEntity<>(studentDTO, HttpStatus.BAD_REQUEST);
    }
}
