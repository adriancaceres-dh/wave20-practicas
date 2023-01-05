package com.bootcamp.be_java_hisp_w20_g6_villamizarmendoza.config;

import com.bootcamp.be_java_hisp_w20_g6_villamizarmendoza.exception.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(UserExistsException.class)
    public ResponseEntity<String> checkUserExists(UserExistsException userExistsException){
        return new ResponseEntity<>(userExistsException.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(FollowerExistsException.class)
    public ResponseEntity<String> checkFolowerExists(FollowerExistsException followerExistsException){
        return new ResponseEntity<>(followerExistsException.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> userNotFound(UserNotFoundException userNotFoundException){
        return new ResponseEntity<>(userNotFoundException.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(FollowerNotFoundException.class)
    public ResponseEntity<String> followerNotFound(FollowerNotFoundException followerNotFoundException){
        return new ResponseEntity<>(followerNotFoundException.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidParamException.class)
    public ResponseEntity<String> invalidParam(InvalidParamException invalidParamException){
        return new ResponseEntity<>(invalidParamException.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(SameUserException.class)
    public ResponseEntity<String> invalidParam(SameUserException sameUserException){
        return new ResponseEntity<>(sameUserException.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
