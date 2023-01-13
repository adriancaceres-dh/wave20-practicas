package com.bootcamp.be_java_hisp_w20_g1.exception;

import com.bootcamp.be_java_hisp_w20_g1.Parameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice(annotations = RestController.class)
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> NotFoundException(Exception e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new MessageException(e.getMessage(), HttpStatus.NOT_FOUND.value()));
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<?> invalidArgumentException(Exception e) {
        return ResponseEntity.badRequest()
                .body(new MessageException(Parameter.getString("EX_Path"), HttpStatus.BAD_REQUEST.value()));
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<?> BadRequestException(Exception e) {
        return ResponseEntity.badRequest()
                .body(new MessageException(e.getMessage(), HttpStatus.BAD_REQUEST.value()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationExceptions(MethodArgumentNotValidException ex) {

        MessageException message = new MessageException(
                "Campos inválidos o faltantes",
                HttpStatus.BAD_REQUEST.value(),
                getListOfInvalidFields(ex)
        );
        return ResponseEntity.badRequest().body(message);
    }

    private List<InvalidValidationMessage> getListOfInvalidFields(MethodArgumentNotValidException ex) {
        return ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(e -> new InvalidValidationMessage(e.getField(), e.getRejectedValue().toString(), e.getDefaultMessage()))
                .collect(Collectors.toList());
    }

}
