package com.meli.obtenerdiploma.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@ControllerAdvice
public class ObtenerPromedioExceptionController {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> MethodArgumentNotValidException(HttpServletRequest request, Exception e, MethodArgumentNotValidException result){
        FieldError fieldError = result.getFieldError();
        String response = fieldError.getField() + fieldError.getDefaultMessage();


        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

}
