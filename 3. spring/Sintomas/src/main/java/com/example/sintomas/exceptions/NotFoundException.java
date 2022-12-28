package com.example.sintomas.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NotFoundException extends RuntimeException{
    public NotFoundException(String elemento){
        super("El elemento "+elemento+ " no existe");
    }
}
