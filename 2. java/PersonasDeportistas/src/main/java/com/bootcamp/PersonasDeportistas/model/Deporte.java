package com.bootcamp.PersonasDeportistas.model;

public class Deporte {
    String nombreDeporte;
    int nivel;


    public String getNombreDeporte() {
        
        return nombreDeporte;
    }

    public void setNombreDeporte(String nombreDeporte) {
        this.nombreDeporte = nombreDeporte;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    @Override
    public String toString() {
        return "Deporte{" +
                "nombreDeporte='" + nombreDeporte + '\'' +
                ", nivel=" + nivel +
                '}';
    }
}
