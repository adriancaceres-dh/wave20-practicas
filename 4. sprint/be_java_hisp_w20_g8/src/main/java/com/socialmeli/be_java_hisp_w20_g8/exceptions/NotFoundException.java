package com.socialmeli.be_java_hisp_w20_g8.exceptions;

public class NotFoundException extends  RuntimeException{
    public NotFoundException() {}
    public NotFoundException(String message) {
        super(message);
    }
}
