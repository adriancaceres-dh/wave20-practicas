package com.bootcamp.be_java_hisp_w20_g6_villamizarmendoza.exception;

public class FollowerExistsException extends RuntimeException{

    public FollowerExistsException(String message){
        super(message);
    }
}
