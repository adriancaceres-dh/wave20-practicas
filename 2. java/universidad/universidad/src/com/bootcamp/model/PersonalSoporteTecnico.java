package com.bootcamp.model;

public class PersonalSoporteTecnico extends Personal implements IAsistente {
    public PersonalSoporteTecnico() {
    }

    public PersonalSoporteTecnico(int id, String nombre, String area) {
        super(id, nombre, area);
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
