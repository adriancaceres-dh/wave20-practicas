package com.bootcamp.be_java_hisp_w20_g4_pereyra.exception;

public class BadRequestException extends  RuntimeException{
    public BadRequestException() {
    }
    public BadRequestException(String message){
     super(message);

    }

}
