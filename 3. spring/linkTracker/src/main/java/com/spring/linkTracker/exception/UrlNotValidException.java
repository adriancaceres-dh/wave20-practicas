package com.spring.linkTracker.exception;

public class UrlNotValidException extends RuntimeException{
    public UrlNotValidException() {
    }

    public UrlNotValidException(String message) {
        super(message);
    }
}
