package com.bootcamp.be_java_hisp_w20_g2_alderete.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String message) {
        super(message);
    }

}
