package com.bootcamp.blog.exceptions;

import com.bootcamp.blog.dto.MensajeExceptionDTO;

public class NotFoundException extends RuntimeException{

    private MensajeExceptionDTO mensajeExceptionDTO;

    public NotFoundException() {
    }

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(MensajeExceptionDTO mensajeExceptionDTO) {
        this.mensajeExceptionDTO = mensajeExceptionDTO;
    }

    public MensajeExceptionDTO getMensajeExceptionDTO() {
        return mensajeExceptionDTO;
    }
}
