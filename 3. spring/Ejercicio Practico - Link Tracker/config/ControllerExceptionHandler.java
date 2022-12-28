package com.bootcamp.prueba.config;

import com.bootcamp.prueba.exception.ElementNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ElementNotFoundException.class)
    public ResponseEntity<String> badRequestHandler(Exception exception) {
        return ResponseEntity.badRequest().body(exception.getMessage());
    }

}
