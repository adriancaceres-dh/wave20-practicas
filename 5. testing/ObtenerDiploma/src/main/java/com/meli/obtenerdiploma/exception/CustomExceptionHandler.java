package com.meli.obtenerdiploma.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationExceptions(MethodArgumentNotValidException ex) {

        MessageForException message = new MessageForException(
                "Invalid or missing fields",
                HttpStatus.BAD_REQUEST.value(),
                getListOfInvalidFields(ex)
        );
        return ResponseEntity.badRequest().body(message);
    }

    private List<InvalidValidationMessage> getListOfInvalidFields(MethodArgumentNotValidException ex) {
        return ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(e -> new InvalidValidationMessage(e.getField(), e.getRejectedValue().toString(), e.getDefaultMessage()))
                .collect(Collectors.toList());
    }

}
