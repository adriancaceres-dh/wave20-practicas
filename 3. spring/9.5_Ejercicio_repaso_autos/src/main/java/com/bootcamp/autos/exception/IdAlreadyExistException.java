package com.bootcamp.autos.exception;

public class IdAlreadyExistException extends RuntimeException{

    public IdAlreadyExistException(String mensaje) {
        super(mensaje);
    }
}
