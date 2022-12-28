package com.example.blog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@ControllerAdvice(annotations = RestController.class)
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> NotFoundException(Exception e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new MessageException(e.getMessage(),LocalDateTime.now().toString()));
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<?> BadRequestException(Exception e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new MessageException(e.getMessage(),LocalDateTime.now().toString()));
    }
}
