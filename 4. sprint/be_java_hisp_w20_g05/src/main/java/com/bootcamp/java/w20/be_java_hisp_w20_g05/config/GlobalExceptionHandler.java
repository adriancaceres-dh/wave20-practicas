package com.bootcamp.java.w20.be_java_hisp_w20_g05.config;

import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.MessageExceptionDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.exceptions.IdNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IdNotFoundException.class)
    public ResponseEntity<MessageExceptionDTO> IdNotFoundException(IdNotFoundException e){
        return new ResponseEntity<>(e.getMessageExceptionDto(), HttpStatus.NOT_FOUND);
    }

}
