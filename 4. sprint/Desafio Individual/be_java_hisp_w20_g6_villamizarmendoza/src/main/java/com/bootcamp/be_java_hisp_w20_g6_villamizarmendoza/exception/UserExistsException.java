package com.bootcamp.be_java_hisp_w20_g6_villamizarmendoza.exception;

public class UserExistsException extends RuntimeException {
    public UserExistsException(String message){
        super(message);
    }
}
