package com.bootcamp.blog.dto;


public class MensajeExceptionDto {
    private String mensaje;


    public MensajeExceptionDto(){}
    public MensajeExceptionDto(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
