package com.bootcamp.be_java_hisp_w20_g1_berthet.exception;

public class NotFoundException extends RuntimeException {

    public NotFoundException() {
    }

    public NotFoundException(String message) {
        super(message);
    }
}
