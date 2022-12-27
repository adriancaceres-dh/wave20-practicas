package com.example.ejercicio_covid19.dto.response;

public class SintomaResponseDto {
    private int codigo;
    private String nombre;
    private String nivelDeGravedad;

    public  SintomaResponseDto(){}


    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNivelDeGravedad() {
        return nivelDeGravedad;
    }

    public void setNivelDeGravedad(String nivelDeGravedad) {
        this.nivelDeGravedad = nivelDeGravedad;
    }
}
