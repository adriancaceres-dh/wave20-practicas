package com.bootcamp.joyeria.exception;

public class NotFoundException extends RuntimeException{

    public NotFoundException(String mensaje){
        super(mensaje);
    }
}
