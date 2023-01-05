package com.bootcamp.be_java_hisp_w20_g2_espindola.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String message) {
        super(message);
    }

}
