package com.bootcamp.springdtop1deportistas.dto.request;

public class DeportistaRequestDTO {
    private String nombreApellido;
    private int edad;
    private String nombreDeporte;
    private String nivelDeporte;

    public DeportistaRequestDTO(String nombreApellido, int edad, String nombreDeporte, String nivelDeporte) {
        this.nombreApellido = nombreApellido;
        this.edad = edad;
        this.nombreDeporte = nombreDeporte;
        this.nivelDeporte = nivelDeporte;
    }

    public String getNombreApellido() {
        return nombreApellido;
    }

    public int getEdad() {
        return edad;
    }

    public String getNombreDeporte() {
        return nombreDeporte;
    }

    public String getNivelDeporte() {
        return nivelDeporte;
    }
}
