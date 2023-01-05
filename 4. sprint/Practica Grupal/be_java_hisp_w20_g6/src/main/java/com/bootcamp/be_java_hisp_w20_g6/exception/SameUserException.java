package com.bootcamp.be_java_hisp_w20_g6.exception;

public class SameUserException extends RuntimeException{

    public SameUserException(String message){
        super(message);
    }
}
