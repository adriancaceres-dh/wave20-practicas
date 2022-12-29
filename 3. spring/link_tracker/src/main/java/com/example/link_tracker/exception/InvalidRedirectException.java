package com.example.link_tracker.exception;

public class InvalidRedirectException extends RuntimeException{

    public InvalidRedirectException(String message) {
        super(message);
    }
}
