package com.meli.obtenerdiploma.exception;

import com.meli.obtenerdiploma.model.ValidationDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {


    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<ValidationDTO> handleValidationExceptions(MethodArgumentNotValidException e) {
        ValidationDTO error = new ValidationDTO("MethodArgumentNotValidException", e.getBindingResult().getFieldError().getDefaultMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    protected ResponseEntity<ValidationDTO> handleValidationExceptions(HttpMessageNotReadableException e) {
        ValidationDTO error = new ValidationDTO("HttpMessageNotReadableException", e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
