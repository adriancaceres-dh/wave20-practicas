package com.bootcamp.be_java_hisp_w20_g7.exception;

import com.bootcamp.be_java_hisp_w20_g7.dto.exception.ExceptionDTO;
import com.bootcamp.be_java_hisp_w20_g7.dto.exception.ExceptionValidationDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice(annotations = RestController.class)
public class GlobalExceptionHandler {

    @ExceptionHandler(FollowAlreadyExistException.class)
    public ResponseEntity<?> FollowAlreadyExistException(Exception e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ExceptionDTO> userNotFoundException(Exception e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionDTO("UserNotFoundException","User Not Found"));
    }

    @ExceptionHandler(UnfollowNotExistException.class)
    public ResponseEntity<?> UnFollowNotExistException(Exception e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(DataIsnotCorrectException.class)
    public ResponseEntity<?> dataIsNotCorrect(Exception e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(PostEmptyException.class)
    public ResponseEntity<?> postEmpty(Exception e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionValidationDto> postEmpty(MethodArgumentNotValidException e, BindingResult r) {
        List<String> errosMessages = r.getAllErrors().stream().map(error -> error.getDefaultMessage()).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionValidationDto("Invalid field",errosMessages));
    }

}
