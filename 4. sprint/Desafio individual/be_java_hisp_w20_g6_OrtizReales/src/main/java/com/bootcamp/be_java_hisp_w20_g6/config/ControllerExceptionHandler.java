package com.bootcamp.be_java_hisp_w20_g6.config;

import com.bootcamp.be_java_hisp_w20_g6.exception.FollowerExistsException;
import com.bootcamp.be_java_hisp_w20_g6.exception.FollowerNotFoundException;
import com.bootcamp.be_java_hisp_w20_g6.exception.InvalidParamException;
import com.bootcamp.be_java_hisp_w20_g6.exception.PostNotFoundException;
import com.bootcamp.be_java_hisp_w20_g6.exception.SameUserException;
import com.bootcamp.be_java_hisp_w20_g6.exception.UserExistsException;
import com.bootcamp.be_java_hisp_w20_g6.exception.UserNotFoundException;
import com.bootcamp.be_java_hisp_w20_g6.exception.UserReactionExistException;

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

    @ExceptionHandler(PostNotFoundException.class)
    public ResponseEntity<String> postNotFound(PostNotFoundException postNotFoundException){
        return new ResponseEntity<>(postNotFoundException.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserReactionExistException.class)
    public ResponseEntity<String> postNotFound(UserReactionExistException userReactionExistException){
        return new ResponseEntity<>(userReactionExistException.getMessage(), HttpStatus.BAD_REQUEST);
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
