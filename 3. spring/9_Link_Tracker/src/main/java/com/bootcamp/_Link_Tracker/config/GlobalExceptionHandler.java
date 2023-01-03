package com.bootcamp._Link_Tracker.config;

import com.bootcamp._Link_Tracker.dto.MessageExceptionDTO;
import com.bootcamp._Link_Tracker.exceptions.IdNotFoundException;
import com.bootcamp._Link_Tracker.exceptions.InvalidLinkException;
import com.bootcamp._Link_Tracker.exceptions.InvalidPasswordException;
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

    @ExceptionHandler(InvalidLinkException.class)
    public ResponseEntity<MessageExceptionDTO> InvalidLinkException(InvalidLinkException e){
        return new ResponseEntity<>(e.getMessageExceptionDto(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidPasswordException.class)
    public ResponseEntity<MessageExceptionDTO> InvalidPasswordException(InvalidPasswordException e){
        return new ResponseEntity<>(e.getMessageExceptionDto(), HttpStatus.BAD_REQUEST);
    }

}