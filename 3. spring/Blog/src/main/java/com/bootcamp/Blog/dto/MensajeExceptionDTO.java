package com.bootcamp.Blog.dto;

public class MensajeExceptionDTO {
    private String mensaje;
    private String fecha;

    private String error;

    public MensajeExceptionDTO() {}

    public MensajeExceptionDTO(String mensaje) {
        this.mensaje = mensaje;
    }
    public MensajeExceptionDTO(String mensaje, String fecha) {
        this.mensaje = mensaje;
        this.fecha = fecha;
    }

    public String getMensaje() {
        return mensaje;
    }

    public String getFecha() {
        return fecha;
    }
}
