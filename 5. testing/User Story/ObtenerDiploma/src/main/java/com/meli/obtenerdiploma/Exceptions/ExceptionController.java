package com.meli.obtenerdiploma.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionController{

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<InvalidArgumentException> handleValidationExceptions(MethodArgumentNotValidException ex) {
        InvalidArgumentException invalidArgumentException = new InvalidArgumentException(ex.getMessage());
        return new ResponseEntity<>(invalidArgumentException, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    protected ResponseEntity<InvalidArgumentException> handleValidationExceptions(HttpMessageNotReadableException ex) {
        InvalidArgumentException invalidArgumentException = new InvalidArgumentException(ex.getMessage());
        return new ResponseEntity<>(invalidArgumentException, HttpStatus.BAD_REQUEST);
    }
}
