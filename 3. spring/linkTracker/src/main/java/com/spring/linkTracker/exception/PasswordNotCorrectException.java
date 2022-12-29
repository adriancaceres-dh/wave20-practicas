package com.spring.linkTracker.exception;

public class PasswordNotCorrectException extends RuntimeException{
    public PasswordNotCorrectException() {
    }

    public PasswordNotCorrectException(String message) {
        super(message);
    }
}
