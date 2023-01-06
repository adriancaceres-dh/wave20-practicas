package com.bootcamp.model;

public class Estudiante extends Persona implements IAprender {
    private String carrera;

    public Estudiante() {
    }

    public Estudiante(int id, String nombre) {
        super(id, nombre);
    }

    public Estudiante(int id, String nombre, String carrera) {
        super(id, nombre);
        this.carrera = carrera;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    @Override
    public String tomarNotas() {
        return null;
    }

    @Override
    public String estudiar() {
        return null;
    }
}
