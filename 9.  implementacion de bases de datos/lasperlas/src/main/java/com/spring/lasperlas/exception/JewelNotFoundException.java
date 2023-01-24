package com.spring.lasperlas.exception;

public class JewelNotFoundException extends RuntimeException{
    public JewelNotFoundException() {
    }

    public JewelNotFoundException(String message) {
        super(message);
    }
}
