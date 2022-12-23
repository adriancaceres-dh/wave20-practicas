package com.bootcamp.deportistas.dto.response;

public class DeportistaResponseDto {

    String nombreCompleto;
    String nombreDeporte;

    public DeportistaResponseDto(String nombreCompleto, String nombreDeporte) {
        this.nombreCompleto = nombreCompleto;
        this.nombreDeporte = nombreDeporte;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getNombreDeporte() {
        return nombreDeporte;
    }

    public void setNombreDeporte(String nombreDeporte) {
        this.nombreDeporte = nombreDeporte;
    }
}
