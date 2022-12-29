package com.bootcamp.be_java_hisp_w20_g2.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(PostCreationException.class)
    public ResponseEntity<String> postCreationException(PostCreationException postCreationException) {
        return ResponseEntity.badRequest().body(postCreationException.getMessage());
    }
}
