package com.spring.lasperlas.exception;

public class JewelAlreadyDeletedException extends RuntimeException{
    public JewelAlreadyDeletedException() {
    }

    public JewelAlreadyDeletedException(String message) {
        super(message);
    }
}
