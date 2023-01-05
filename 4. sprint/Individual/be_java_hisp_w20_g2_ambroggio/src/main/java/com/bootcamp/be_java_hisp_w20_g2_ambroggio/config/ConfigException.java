package com.bootcamp.be_java_hisp_w20_g2_ambroggio.config;

import com.bootcamp.be_java_hisp_w20_g2_ambroggio.dto.MessageExceptionDTO;
import com.bootcamp.be_java_hisp_w20_g2_ambroggio.exception.BadRequestException;
import com.bootcamp.be_java_hisp_w20_g2_ambroggio.exception.PostCreationException;
import com.bootcamp.be_java_hisp_w20_g2_ambroggio.exception.UserNotFoundException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@ControllerAdvice
public class ConfigException {
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<MessageExceptionDTO> exception(BadRequestException exception, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new MessageExceptionDTO(exception.getMessage(), HttpStatus.BAD_REQUEST.value(), request.getRequestURI(), LocalDateTime.now()));

    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<MessageExceptionDTO> userNotFoundException(UserNotFoundException exception, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new MessageExceptionDTO(exception.getMessage(), HttpStatus.NOT_FOUND.value(), request.getRequestURI(), LocalDateTime.now()));
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
