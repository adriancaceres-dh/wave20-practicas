package com.bootcamp.linktracker.exception;

public class WrongOrEmptyPasswordException extends RuntimeException {
    public WrongOrEmptyPasswordException(String message) {
        super(message);
    }
}
