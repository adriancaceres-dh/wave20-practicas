package com.bootcamp.be_java_hisp_w20_g7_anttury.exception;


public class FollowAlreadyExistException extends RuntimeException {

    public FollowAlreadyExistException() {

    }

    public FollowAlreadyExistException(String mensaje) {
        super(mensaje);
    }
}
