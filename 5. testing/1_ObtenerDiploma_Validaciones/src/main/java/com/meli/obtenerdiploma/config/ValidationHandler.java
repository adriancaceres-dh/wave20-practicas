package com.meli.obtenerdiploma.config;

import com.meli.obtenerdiploma.dto.MessageExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.handler.ResponseStatusExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ValidationHandler extends ResponseStatusExceptionHandler{

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<MessageExceptionDto> handleValidationException(MethodArgumentNotValidException e){
        return new ResponseEntity<>(new MessageExceptionDto(e.getBindingResult().getFieldError().getDefaultMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    protected ResponseEntity<MessageExceptionDto> handleValidationException(HttpMessageNotReadableException e){
        return new ResponseEntity<>(new MessageExceptionDto(e.getMessage()), HttpStatus.BAD_REQUEST);
    }

}
