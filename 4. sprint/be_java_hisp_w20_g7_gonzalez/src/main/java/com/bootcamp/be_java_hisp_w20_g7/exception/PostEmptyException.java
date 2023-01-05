package com.bootcamp.be_java_hisp_w20_g7.exception;

public class PostEmptyException extends RuntimeException {

    public PostEmptyException(String message) {
        super(message);
    }
}
