package com.bootcamp.blog.exceptions;

import com.bootcamp.blog.dto.MensajeEntradaBlogResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControlerHandlerException {

    @ExceptionHandler(IdAreadyExist.class)
    public ResponseEntity<MensajeEntradaBlogResponseDto> idAlreadyExist(IdAreadyExist e){
        return new ResponseEntity<>(e.getMensajeEntradaBlogResponseDto(), HttpStatus.I_AM_A_TEAPOT);
    }

    @ExceptionHandler(IdNotFoundException.class)
    public ResponseEntity<String> idAlreadyExist(Exception e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.I_AM_A_TEAPOT);
    }
}
