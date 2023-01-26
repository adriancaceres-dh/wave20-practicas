package com.bootcamp20.lasPerlas.config;

import com.bootcamp20.lasPerlas.dtos.ErrorDTO;
import com.bootcamp20.lasPerlas.exceptions.InvalidArgumentException;
import com.bootcamp20.lasPerlas.exceptions.OperationFailedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
public class GlobalExceptionHandler {

    @ExceptionHandler(OperationFailedException.class)
    public ResponseEntity<?> operationFailedException(Exception e) {
        ErrorDTO error = ErrorDTO.builder()
                .name("Excepcion de operacion fallida!")
                .description(e.getMessage())
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(InvalidArgumentException.class)
    public ResponseEntity<?> invalidArgumentException(Exception e) {
        ErrorDTO error = ErrorDTO.builder()
                .name("Argumento Invalido!")
                .description(e.getMessage())
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}
