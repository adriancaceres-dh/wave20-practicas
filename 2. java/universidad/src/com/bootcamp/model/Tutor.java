package com.bootcamp.model;

public class Tutor extends Estudiante implements IEducador {
    public Tutor() {
    }

    public Tutor(int id, String nombre) {
        super(id, nombre);
    }

    public Tutor(int id, String nombre, String carrera) {
        super(id, nombre, carrera);
    }

    @Override
    public String educar() {
        return null;
    }

    @Override
    public String calificar() {
        return null;
    }
}
