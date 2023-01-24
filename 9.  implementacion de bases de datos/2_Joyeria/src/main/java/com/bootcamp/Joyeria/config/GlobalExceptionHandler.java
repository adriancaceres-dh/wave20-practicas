package com.bootcamp.Joyeria.config;

import com.bootcamp.Joyeria.dto.MessageExceptionDTO;
import com.bootcamp.Joyeria.exceptions.JoyaNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(JoyaNotFoundException.class)
    public ResponseEntity<MessageExceptionDTO> joyaNotFoundException(JoyaNotFoundException e){
        return new ResponseEntity<>(e.getMessageExceptionDto(), HttpStatus.NOT_FOUND);
    }

}
