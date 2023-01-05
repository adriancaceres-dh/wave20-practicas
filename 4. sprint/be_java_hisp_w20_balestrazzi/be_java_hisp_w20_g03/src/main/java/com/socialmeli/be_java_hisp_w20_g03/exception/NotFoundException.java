package com.socialmeli.be_java_hisp_w20_g03.exception;

public class NotFoundException extends RuntimeException{

    public NotFoundException(String mensaje){
        super(mensaje);
    }
}
