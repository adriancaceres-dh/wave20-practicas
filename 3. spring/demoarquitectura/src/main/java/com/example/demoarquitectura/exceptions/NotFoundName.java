package com.example.demoarquitectura.exceptions;


public class NotFoundName extends RuntimeException {

    public NotFoundName() {

    }

    public NotFoundName(String message) {
        super(message);
    }


}
