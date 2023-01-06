package com.bootcamp.model;

public class EstudianteTecnico extends Estudiante implements IAsistente {
    public EstudianteTecnico() {
    }

    public EstudianteTecnico(int id, String nombre) {
        super(id, nombre);
    }

    public EstudianteTecnico(int id, String nombre, String carrera) {
        super(id, nombre, carrera);
    }

    @Override
    public String darSoporte() {
        return null;
    }

    @Override
    public String asistir() {
        return null;
    }
}
