package com.spring.lasperlas.exception;

import com.spring.lasperlas.dto.MessageDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
public class GlobalExceptionHandler {
    @ExceptionHandler(JewelNotFoundException.class)
    public ResponseEntity<?> NotFoundException(Exception e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new MessageDTO("Jewel not Found Exception",e.getMessage()));
    }
    @ExceptionHandler(JewelAlreadyDeletedException.class)
    public ResponseEntity<?> AlreadyDeletedException(Exception e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MessageDTO("Jewel already deleted",e.getMessage()));
    }
}
