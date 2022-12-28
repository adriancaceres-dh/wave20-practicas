package com.bootcamp.Blog.exception;

import com.bootcamp.Blog.dto.MensajeExceptionDTO;

public class AlredyExistException extends RuntimeException{

    MensajeExceptionDTO mensajeExceptionDTO;

    public AlredyExistException(){}
    public AlredyExistException(MensajeExceptionDTO mensajeExceptionDTO){
        this.mensajeExceptionDTO = mensajeExceptionDTO;
    }

    public MensajeExceptionDTO getMensajeExceptionDTO() {
        return mensajeExceptionDTO;
    }
}
