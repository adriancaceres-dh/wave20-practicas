package com.joyeria.joyeria.exception;

import com.fasterxml.jackson.databind.JsonMappingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@ControllerAdvice(annotations = RestController.class)
public class GlobalExceptionHandler {

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<?> messageNotReadableException(HttpMessageNotReadableException e) {
        JsonMappingException cause = (JsonMappingException) e.getCause();
        String invalidField = cause.getPath().get(0).getFieldName();

        return ResponseEntity.badRequest()
                .body(new MessageException(
                        "Tipo de dato inválido en " + invalidField,
                        HttpStatus.BAD_REQUEST.value()
                ));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationExceptions(MethodArgumentNotValidException ex) {
        MessageException message = new MessageException(
                "Campos inválidos o faltantes",
                HttpStatus.BAD_REQUEST.value(),
                getListOfInvalidFields(ex)
        );
        return ResponseEntity.badRequest().body(message);
    }

    private Set<InvalidValidationMessage> getListOfInvalidFields(MethodArgumentNotValidException ex) {
        return ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(e -> {
                            String rejectedValue = Objects.isNull(e.getRejectedValue()) ? "empty field" : e.getRejectedValue().toString();
                            return new InvalidValidationMessage(e.getField(), rejectedValue, e.getDefaultMessage());
                        }
                )
                .collect(Collectors.toSet());
    }
}
