package com.bootcamp.link_tracker.exception;

public class IncorrectPasswordException extends RuntimeException {
    private static final String message = "Incorrect password";

    public IncorrectPasswordException() {
        super(message);
    }
}
