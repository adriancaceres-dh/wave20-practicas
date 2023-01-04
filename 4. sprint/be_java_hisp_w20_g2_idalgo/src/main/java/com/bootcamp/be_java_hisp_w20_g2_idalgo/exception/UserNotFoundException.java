package com.bootcamp.be_java_hisp_w20_g2_idalgo.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String message) {
        super(message);
    }

}
