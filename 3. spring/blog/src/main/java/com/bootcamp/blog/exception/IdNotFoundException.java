package com.bootcamp.blog.exception;


import com.bootcamp.blog.dto.MensajeExceptionDto;

// @ResponseStatus(value= HttpStatus.NOT_FOUND,reason = "Id no existente")
public class IdNotFoundException extends RuntimeException{
    private MensajeExceptionDto mensajeExceptionDto;
    public IdNotFoundException(MensajeExceptionDto mensajeExceptionDto) {
        this.mensajeExceptionDto = mensajeExceptionDto;
        // super(mensaje);
    }

    public MensajeExceptionDto getMensajeExceptionDto() {
        return mensajeExceptionDto;
    }

    public void setMensajeExceptionDto(MensajeExceptionDto mensajeExceptionDto) {
        this.mensajeExceptionDto = mensajeExceptionDto;
    }
}
