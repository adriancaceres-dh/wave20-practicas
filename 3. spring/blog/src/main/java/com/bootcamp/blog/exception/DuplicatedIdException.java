package com.bootcamp.blog.exception;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class DuplicatedIdException extends RuntimeException{
    public DuplicatedIdException(String message) {
        super(message);
    }
}
