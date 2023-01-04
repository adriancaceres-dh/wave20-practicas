package com.bootcamp.be_java_hisp_w20_g6.exception;

public class InvalidParamException extends RuntimeException {

    public InvalidParamException(String message) {
        super(message);
    }
}
