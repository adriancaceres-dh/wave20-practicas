package com.bootcamp.ejercicio_link_tracker.config;

import com.bootcamp.ejercicio_link_tracker.exception.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.net.http.HttpResponse;

@ControllerAdvice
public class ConfigException {
    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<String> exceptionResponseEntity(ValidationException exception){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());

    }
}
