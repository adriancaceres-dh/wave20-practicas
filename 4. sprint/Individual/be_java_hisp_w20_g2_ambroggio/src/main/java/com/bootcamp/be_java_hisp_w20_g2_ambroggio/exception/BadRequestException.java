package com.bootcamp.be_java_hisp_w20_g2_ambroggio.exception;

public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {
        super(message);
    }
}
