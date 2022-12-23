package com.bootcamp.deportes.dto.response;

public class PersonaResponseDto {
    private String nombre;
    private String apellido;
    private String nombreDeporte;

    public PersonaResponseDto() {
    }

    public PersonaResponseDto(String nombre, String apellido, String nombreDeporte) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nombreDeporte = nombreDeporte;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombreDeporte() {
        return nombreDeporte;
    }

    public void setNombreDeporte(String nombreDeporte) {
        this.nombreDeporte = nombreDeporte;
    }

    @Override
    public String toString() {
        return "PersonaResponseDto{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", nombreDeporte='" + nombreDeporte + '\'' +
                '}';
    }
}
