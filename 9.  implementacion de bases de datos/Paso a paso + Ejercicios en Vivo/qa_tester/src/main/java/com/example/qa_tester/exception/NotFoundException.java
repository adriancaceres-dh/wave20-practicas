package com.example.qa_tester.exception;

public class NotFoundException extends RuntimeException{

    public NotFoundException(String mensaje){
        super(mensaje);
    }
}
