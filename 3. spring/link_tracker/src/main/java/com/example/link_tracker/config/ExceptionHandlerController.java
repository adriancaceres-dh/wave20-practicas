package com.example.link_tracker.config;

import com.example.link_tracker.dto.MessageLinkDto;
import com.example.link_tracker.exception.InvalidRedirectException;
import com.example.link_tracker.exception.LinkAlreadyExist;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(InvalidRedirectException.class)
    public ResponseEntity<String> InvalidRedirectException(Exception e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(LinkAlreadyExist.class)
    public ResponseEntity<MessageLinkDto> linkAlreadyExist(LinkAlreadyExist e){

        return new ResponseEntity<>(e.getMessageLinkDto(),HttpStatus.I_AM_A_TEAPOT);
    }
}
