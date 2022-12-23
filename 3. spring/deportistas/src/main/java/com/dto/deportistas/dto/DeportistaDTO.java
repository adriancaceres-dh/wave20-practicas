package com.dto.deportistas.dto;

import com.dto.deportistas.model.DeporteModel;
import com.dto.deportistas.model.PersonaModel;

public class DeportistaDTO {
    private String nombreP;
    private String apellidoP;
    private String nombreD;

    public DeportistaDTO() {
    }

    public DeportistaDTO(String nombreP, String apellidoP, String nombreD) {
        this.nombreP = nombreP;
        this.apellidoP = apellidoP;
        this.nombreD = nombreD;
    }

    public String getNombreP() {
        return nombreP;
    }

    public void setNombreP(String nombreP) {
        this.nombreP = nombreP;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getNombreD() {
        return nombreD;
    }

    public void setNombreD(String nombreD) {
        this.nombreD = nombreD;
    }

    @Override
    public String toString() {
        return "{" +'\n' +
                "nombrePersona:'" + nombreP + ", \n" +
                "apellidoPersona:'" + apellidoP + ", \n" +
                "nombreDeporte:'" + nombreD + '\n' +
                '}';
    }
}
