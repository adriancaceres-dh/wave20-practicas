package com.bootcamp.be_java_hisp_w20_ramosruiz.exception;

public class NotFoundException extends RuntimeException {

    public NotFoundException() {
    }

    public NotFoundException(String message) {
        super(message);
    }
}
