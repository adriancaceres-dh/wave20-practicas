package com.bootcamp.blog.config;

import com.bootcamp.blog.dto.MensajeEntradaBlogResponseDto;
import com.bootcamp.blog.exception.IdExistException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<MensajeEntradaBlogResponseDto> idExistException(IdExistException e){
        return new ResponseEntity<>(e.getMensajeDto(), HttpStatus.BAD_REQUEST);
    }
}
