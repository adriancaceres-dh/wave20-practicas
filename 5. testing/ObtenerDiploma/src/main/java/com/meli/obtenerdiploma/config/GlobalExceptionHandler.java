package com.meli.obtenerdiploma.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class GlobalExceptionHandler {
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<String> handleValidationExceptions(
    MethodArgumentNotValidException ex) {

    return new ResponseEntity<>(ex.getBindingResult()
            .getFieldError().getDefaultMessage(), HttpStatus.BAD_REQUEST);
  }
}
