package com.bootcamp.model;

public class PersonalMantenimiento extends Personal implements IReparador {
    public PersonalMantenimiento() {
    }

    public PersonalMantenimiento(int id, String nombre, String area) {
        super(id, nombre, area);
    }

    @Override
    public String reparar() {
        return null;
    }

    @Override
    public String darMantenimiento() {
        return null;
    }
}
