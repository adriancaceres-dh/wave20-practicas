package com.bootcamp.blog.config;

import com.bootcamp.blog.dto.OperationResultDTO;
import com.bootcamp.blog.exception.ElementNotFoundException;
import com.bootcamp.blog.exception.UsedIdException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler({UsedIdException.class, ElementNotFoundException.class})
    public ResponseEntity<OperationResultDTO> badRequestHandler(Exception exception) {
        return ResponseEntity.badRequest().body(new OperationResultDTO(false, exception.getMessage()));
    }

}
