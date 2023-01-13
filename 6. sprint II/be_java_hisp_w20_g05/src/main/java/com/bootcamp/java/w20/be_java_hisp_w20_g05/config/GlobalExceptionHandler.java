package com.bootcamp.java.w20.be_java_hisp_w20_g05.config;

import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.MessageExceptionDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.exceptions.IdNotFoundException;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.exceptions.InvalidPostDataException;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.exceptions.WrongRequestParamException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.handler.ResponseStatusExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseStatusExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<MessageExceptionDTO> handleValidationException(MethodArgumentNotValidException e){
        return new ResponseEntity<>(new MessageExceptionDTO(e.getBindingResult().getFieldError().getDefaultMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IdNotFoundException.class)
    public ResponseEntity<MessageExceptionDTO> IdNotFoundException(IdNotFoundException e){
        return new ResponseEntity<>(e.getMessageExceptionDto(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidPostDataException.class)
    public ResponseEntity<MessageExceptionDTO> InvalidPostDataException(InvalidPostDataException e) {
        return new ResponseEntity<>(e.getMessageExceptionDTO(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(WrongRequestParamException.class)
    public ResponseEntity<MessageExceptionDTO> WrongRequestParamException(WrongRequestParamException e){
        return new ResponseEntity<>(e.getMessageExceptionDTO(), HttpStatus.BAD_REQUEST);
    }
}
