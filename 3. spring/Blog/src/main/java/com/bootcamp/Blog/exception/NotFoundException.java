package com.bootcamp.Blog.exception;

import com.bootcamp.Blog.dto.MensajeExceptionDTO;

public class NotFoundException extends RuntimeException{

    private MensajeExceptionDTO mensajeExceptionDTO;

    public NotFoundException(){}

    public NotFoundException(MensajeExceptionDTO mensajeExceptionDTO){
        this.mensajeExceptionDTO = mensajeExceptionDTO;
    }

    public MensajeExceptionDTO getMensajeExceptionDTO() {
        return mensajeExceptionDTO;
    }
}
