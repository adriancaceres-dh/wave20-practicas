package com.example.lasperlas.exception;

public class NotFoundException extends RuntimeException {


    public NotFoundException(Long id) {
        super("Nro identificatorio no encontrado: " + id);
    }
}
