package com.bootcamp.DeportesPersona.colector;

public class Deporte {

    String nombreDeporte;
    int nivel;


    public Deporte(String nombreDeporte, int nivel) {
        this.nombreDeporte = nombreDeporte;
        this.nivel = nivel;
    }

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
