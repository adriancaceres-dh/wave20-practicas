package com.bootcamp.be_java_hisp_w20_g6_villamizar.exception;

public class FollowerNotFoundException extends RuntimeException{

    public FollowerNotFoundException(String message){
        super(message);
    }
}
