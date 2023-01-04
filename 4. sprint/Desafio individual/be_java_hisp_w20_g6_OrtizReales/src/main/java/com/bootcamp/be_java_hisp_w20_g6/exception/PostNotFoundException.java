package com.bootcamp.be_java_hisp_w20_g6.exception;

public class PostNotFoundException extends RuntimeException {
    public PostNotFoundException(String message) {
        super(message);
    }
}
