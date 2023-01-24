package com.JPA.demo.config;

import com.JPA.demo.dto.MessageDTO;
import com.JPA.demo.exceptions.PersonNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {

      @ExceptionHandler(PersonNotFoundException.class)
      ResponseEntity<MessageDTO> personNotFound(PersonNotFoundException e) {
          return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(MessageDTO.builder()
                  .message(e.getMessage())
                  .build());
      }
}
