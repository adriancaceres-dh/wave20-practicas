package com.bootcamp.java.w20.be_java_hisp_w20_g05.config;

import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.MessageExceptionDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

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
    @ExceptionHandler(NotPromotionException.class)
    public ResponseEntity<MessageExceptionDTO> NotPromotionException(NotPromotionException e){
        return new ResponseEntity<>(e.getMessageExceptionDTO(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AlreadyPostedPromoException.class)
    public ResponseEntity<MessageExceptionDTO> AlreadyPostedPromoException(AlreadyPostedPromoException e){
        return new ResponseEntity<>(e.getMessageExceptionDTO(), HttpStatus.BAD_REQUEST);
    }
}
