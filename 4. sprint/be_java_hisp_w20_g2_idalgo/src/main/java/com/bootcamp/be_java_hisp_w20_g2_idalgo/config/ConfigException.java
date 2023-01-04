package com.bootcamp.be_java_hisp_w20_g2_idalgo.config;

import com.bootcamp.be_java_hisp_w20_g2_idalgo.exception.BadRequestException;
import com.bootcamp.be_java_hisp_w20_g2_idalgo.exception.PostCreationException;
import com.bootcamp.be_java_hisp_w20_g2_idalgo.exception.UserNotFoundException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class ConfigException {
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<String> exception(BadRequestException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(exception.getMessage());

    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> userNotFoundException(UserNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }

    @ExceptionHandler(PostCreationException.class)
    public ResponseEntity<String> postCreationException(PostCreationException postCreationException) {
        return ResponseEntity.badRequest().body(postCreationException.getMessage());
    }

    @ExceptionHandler(InvalidFormatException.class)
    public ResponseEntity<String> jsonDeserializing(InvalidFormatException exception) {
        return ResponseEntity.badRequest().body("Invalid JSON in request body");
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<String> methodArgumentMismatch(MethodArgumentTypeMismatchException exception) {
        return ResponseEntity.badRequest().body("Invalid query or path parameter");
    }
}
