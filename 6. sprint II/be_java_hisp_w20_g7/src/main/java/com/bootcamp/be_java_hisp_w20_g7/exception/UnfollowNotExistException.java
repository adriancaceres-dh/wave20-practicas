package com.bootcamp.be_java_hisp_w20_g7.exception;

public class UnfollowNotExistException extends RuntimeException {

    public UnfollowNotExistException(String mensaje) {
        super(mensaje);
    }
}
