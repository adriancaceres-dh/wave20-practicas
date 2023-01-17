package com.bootcamp.be_java_hisp_w20_g2.config;

import com.bootcamp.be_java_hisp_w20_g2.exception.BadRequestException;
import com.bootcamp.be_java_hisp_w20_g2.exception.PostCreationException;
import com.bootcamp.be_java_hisp_w20_g2.exception.UserNotFoundException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.stream.Collectors;

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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleValidationExceptions(MethodArgumentNotValidException e) {
        return new ResponseEntity<>(e.getBindingResult().getFieldError().getDefaultMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> handleValidationExceptions(HttpMessageNotReadableException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<String> handleConstraintViolation(ConstraintViolationException e) {
        List<String> messages = e.getConstraintViolations().stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.toList());
        return new ResponseEntity<>(StringUtils.join(messages, '\n'), HttpStatus.BAD_REQUEST);
    }

}
