package com.bootcamp.link_tracker.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<?> badRequest(Exception e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
