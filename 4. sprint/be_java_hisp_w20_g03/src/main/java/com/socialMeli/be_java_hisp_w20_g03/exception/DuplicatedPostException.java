package com.socialMeli.be_java_hisp_w20_g03.exception;

public class DuplicatedPostException extends RuntimeException{

    public DuplicatedPostException(String mensaje){
        super(mensaje);
    }

}
