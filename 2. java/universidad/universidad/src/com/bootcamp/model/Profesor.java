package com.bootcamp.model;

import java.util.Set;

public class Profesor extends Personal implements IEducador {
    private String matricula;
    private Set<String> materias;

    public Profesor() {
    }

    public Profesor(int id, String nombre, String area, String matricula, Set<String> materias) {
        super(id, nombre, area);
        this.matricula = matricula;
        this.materias = materias;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Set<String> getMaterias() {
        return materias;
    }

    public void setMaterias(Set<String> materias) {
        this.materias = materias;
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
