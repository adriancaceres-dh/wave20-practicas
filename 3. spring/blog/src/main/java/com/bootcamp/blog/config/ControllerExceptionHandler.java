package com.bootcamp.blog.config;


import com.bootcamp.blog.dto.MensajeExceptionDto;
import com.bootcamp.blog.exception.DuplicateException;
import com.bootcamp.blog.exception.IdNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(IdNotFoundException.class)
    public ResponseEntity<MensajeExceptionDto> blogNoEncontrado(IdNotFoundException e) {
        return new ResponseEntity<>(e.getMensajeExceptionDto(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DuplicateException.class)
    public ResponseEntity<MensajeExceptionDto> blogDuplicado(DuplicateException e) {
        return new ResponseEntity<>(e.getMensajeExceptionDto(), HttpStatus.CONFLICT);
    }

}
