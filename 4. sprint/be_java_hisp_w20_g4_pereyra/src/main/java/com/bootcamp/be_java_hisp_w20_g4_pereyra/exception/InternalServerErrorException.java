package com.bootcamp.be_java_hisp_w20_g4_pereyra.exception;

public class InternalServerErrorException extends RuntimeException{
    public InternalServerErrorException() {
    }

    public InternalServerErrorException(String message) {
        super(message);
    }
}
