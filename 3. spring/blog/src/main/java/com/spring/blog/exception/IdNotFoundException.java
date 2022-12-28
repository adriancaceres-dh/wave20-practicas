package com.spring.blog.exception;

import com.spring.blog.dto.MensajeEntradaBlogResponseDto;

public class IdNotFoundException extends  RuntimeException{
    MensajeEntradaBlogResponseDto mensaje;
    public IdNotFoundException() {
    }

    public IdNotFoundException(String message) {
        super(message);
    }

    public IdNotFoundException(MensajeEntradaBlogResponseDto mensaje){
        this.mensaje = mensaje;
    }

    public MensajeEntradaBlogResponseDto getMensaje() {
        return mensaje;
    }

    public void setMensaje(MensajeEntradaBlogResponseDto mensaje) {
        this.mensaje = mensaje;
    }
}
