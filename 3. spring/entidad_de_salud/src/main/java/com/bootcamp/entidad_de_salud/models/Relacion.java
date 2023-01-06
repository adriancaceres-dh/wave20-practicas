package com.bootcamp.entidad_de_salud.models;

public class Relacion {
    private int idPersona;
    private int codigoSintoma;

    public Relacion(int idPersona, int codigoSintoma) {
        this.idPersona = idPersona;
        this.codigoSintoma = codigoSintoma;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public int getCodigoSintoma() {
        return codigoSintoma;
    }

    public void setCodigoSintoma(int codigoSintoma) {
        this.codigoSintoma = codigoSintoma;
    }
}
