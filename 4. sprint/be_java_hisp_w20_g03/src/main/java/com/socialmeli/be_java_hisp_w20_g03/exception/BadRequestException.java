package com.socialmeli.be_java_hisp_w20_g03.exception;

public class BadRequestException extends RuntimeException{

    public BadRequestException(String message) {
        super(message);
    }
}
