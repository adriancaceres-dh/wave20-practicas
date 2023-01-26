package com.bootcamp.movies_hql.exception;

public class NotFoundException extends RuntimeException{

    public NotFoundException(String mensaje){
        super(mensaje);
    }
}
