package com.bootcamp.linktracker.exception;

import com.bootcamp.linktracker.config.MessagesUtil;
import com.bootcamp.linktracker.dto.OperationResultDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Optional;

@ControllerAdvice
public class ControllerExceptionsHandler {
    @ExceptionHandler(LinkNotFoundException.class)
    public ResponseEntity<OperationResultDTO> LinkNotFoundException(LinkNotFoundException exception) {
        return ResponseEntity.badRequest().body(new OperationResultDTO(Optional.empty(), exception.getMessage(), false));
    }

    @ExceptionHandler(WrongOrEmptyPasswordException.class)
    public ResponseEntity<OperationResultDTO> WrongOrEmptyPasswordException(WrongOrEmptyPasswordException exception) {
        return ResponseEntity.badRequest().body(new OperationResultDTO(Optional.empty(), MessagesUtil.LINK_NOT_FOUND, false));
    }

}
