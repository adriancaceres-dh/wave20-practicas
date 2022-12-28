package com.bootcamp.springdtop1deportistas.dto.response;

public class DeportistaResponseDTO {
    private String nombreApellido;
    private String nombreDeporte;

    public String getNombreApellido() {
        return nombreApellido;
    }

    public String getNombreDeporte() {
        return nombreDeporte;
    }

    public DeportistaResponseDTO(String nombreApellido, String nombreDeporte) {
        this.nombreApellido = nombreApellido;
        this.nombreDeporte = nombreDeporte;
    }
}
