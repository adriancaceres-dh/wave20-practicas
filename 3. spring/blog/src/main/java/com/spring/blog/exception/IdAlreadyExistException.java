package com.spring.blog.exception;

import com.spring.blog.dto.MensajeEntradaBlogResponseDto;

public class IdAlreadyExistException extends  RuntimeException{
    MensajeEntradaBlogResponseDto mensaje;

    public IdAlreadyExistException() {
    }

    public IdAlreadyExistException(String message) {
        super(message);
    }

    public IdAlreadyExistException(MensajeEntradaBlogResponseDto mensaje){
        this.mensaje = mensaje;
    }

    public MensajeEntradaBlogResponseDto getMensaje() {
        return mensaje;
    }

    public void setMensaje(MensajeEntradaBlogResponseDto mensaje) {
        this.mensaje = mensaje;
    }
}
