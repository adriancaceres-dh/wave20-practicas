package com.bootcamp.be_java_hisp_w20_g6.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bootcamp.be_java_hisp_w20_g6.dto.response.ErrorResponseDto;
import com.bootcamp.be_java_hisp_w20_g6.exception.*;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(UserExistsException.class)
    public ResponseEntity<ErrorResponseDto> checkUserExists(UserExistsException e){
        ErrorResponseDto error = new ErrorResponseDto("UserExistException", e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(FollowerExistsException.class)
    public ResponseEntity<ErrorResponseDto> checkFolowerExists(FollowerExistsException e){
        ErrorResponseDto error = new ErrorResponseDto("FollowerExistsException", e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> userNotFound(UserNotFoundException e){
        ErrorResponseDto error = new ErrorResponseDto("UserNotFoundException", e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(FollowerNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> followerNotFound(FollowerNotFoundException e){
        ErrorResponseDto error = new ErrorResponseDto("FollowerNotFoundException", e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidParamException.class)
    public ResponseEntity<ErrorResponseDto> invalidParam(InvalidParamException e){
        ErrorResponseDto error = new ErrorResponseDto("InvalidParamException", e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(SameUserException.class)
    public ResponseEntity<ErrorResponseDto> invalidParam(SameUserException e){
        ErrorResponseDto error = new ErrorResponseDto("SameUserException", e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponseDto> invalidParam(MethodArgumentNotValidException e){
        ErrorResponseDto error = new ErrorResponseDto("MethodArgumentNotValidException", e.getBindingResult().getFieldError().getDefaultMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    protected ResponseEntity<ErrorResponseDto> handleValidationExceptions(HttpMessageNotReadableException e) {
        ErrorResponseDto error = new ErrorResponseDto("HttpMessageNotReadableException", e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

}
