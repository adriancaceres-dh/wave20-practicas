package com.bootcamp.be_java_hisp_w20_g1_demarchi.exception;

import com.bootcamp.be_java_hisp_w20_g1_demarchi.Parameter;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.Objects;
import java.util.Set;
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

    @ExceptionHandler(InvalidQueryParamValueException.class)
    public ResponseEntity<?> InvalidQueryParamValueException(Exception e) {
        return ResponseEntity.unprocessableEntity()
                .body(new MessageException(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY.value()));
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<?> messageNotReadableException(HttpMessageNotReadableException e) {
        JsonMappingException cause = (JsonMappingException) e.getCause();
        String invalidField = cause.getPath().get(0).getFieldName();

        return ResponseEntity.badRequest()
                .body(new MessageException(
                        "Tipo de dato inválido en " + invalidField,
                        HttpStatus.BAD_REQUEST.value()
                ));
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

    private Set<InvalidValidationMessage> getListOfInvalidFields(MethodArgumentNotValidException ex) {
        return ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(e -> {
                            String rejectedValue = Objects.isNull(e.getRejectedValue()) ? "empty field" : e.getRejectedValue().toString();
                            return new InvalidValidationMessage(e.getField(), rejectedValue, e.getDefaultMessage());
                        }
                )
                .collect(Collectors.toSet());
    }

}
