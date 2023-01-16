package com.bootcamp.be_java_hisp_w20_g4_pereyra.exception;


import com.bootcamp.be_java_hisp_w20_g4_pereyra.dto.error.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public  ResponseEntity<?> NotFoundException(Exception e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorDTO("Not Found Exception",e.getMessage()));
    }

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidateExceptions(MethodArgumentNotValidException e) {
        return ResponseEntity.badRequest().body(new ErrorDTO("Method Argument Not Valid Exception exception",e.getBindingResult().getFieldError().getDefaultMessage()));
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<?> BadRequestException(Exception e){
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorDTO("Bad Request Exception",e.getMessage()));
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<?> validationException(HttpMessageNotReadableException e){
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorDTO("Http Message Not Readable Exception",e.getMessage()));
    }
}
