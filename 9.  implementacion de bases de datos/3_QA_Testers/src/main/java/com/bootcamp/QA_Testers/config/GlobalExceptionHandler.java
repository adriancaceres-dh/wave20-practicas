package com.bootcamp.QA_Testers.config;


import com.bootcamp.QA_Testers.dto.MessageExceptionDTO;
import com.bootcamp.QA_Testers.exceptions.TestNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(TestNotFoundException.class)
    public ResponseEntity<MessageExceptionDTO> testNotFoundException(TestNotFoundException e){
        return new ResponseEntity<>(e.getMessageExceptionDto(), HttpStatus.NOT_FOUND);
    }
}
