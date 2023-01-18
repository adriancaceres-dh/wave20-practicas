package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationExceptions(MethodArgumentNotValidException ex){
        ErrorDTO error = new ErrorDTO(ex.getBindingResult().getFieldError().getDefaultMessage());
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }

}
