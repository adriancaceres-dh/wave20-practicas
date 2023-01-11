package com.meli.obtenerdiploma.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice(annotations = RestController.class)
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> NotFoundException(Exception e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidateExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<String, String>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String message = error.getDefaultMessage();

            errors.put(fieldName, message);
        });

        return errors;
    }
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<?> BadRequestException(Exception e){
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}
