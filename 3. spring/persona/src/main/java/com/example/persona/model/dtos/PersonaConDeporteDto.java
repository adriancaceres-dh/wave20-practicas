package com.example.persona.model.dtos;

public class PersonaConDeporteDto {
    private String Nombre;
    private String Apellido;
    private String NombreDeporte;

    public PersonaConDeporteDto(String nombre, String apellido, String nombreDeporte) {
        Nombre = nombre;
        Apellido = apellido;
        NombreDeporte = nombreDeporte;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getNombreDeporte() {
        return NombreDeporte;
    }

    public void setNombreDeporte(String nombreDeporte) {
        NombreDeporte = nombreDeporte;
    }
}
