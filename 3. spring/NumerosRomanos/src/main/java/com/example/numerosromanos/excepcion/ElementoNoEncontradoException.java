package com.example.numerosromanos.excepcion;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ElementoNoEncontradoException extends RuntimeException{
    public ElementoNoEncontradoException(String message){
        super(message);
    }
}
