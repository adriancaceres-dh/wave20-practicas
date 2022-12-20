package com.bootcamp.clases;

import com.bootcamp.interfaces.DarSoporteTecnicoInterface;

public class PersonaSoporteTecnico extends Persona implements DarSoporteTecnicoInterface {

    private String areaSoporte;

    public PersonaSoporteTecnico(String nombre, String apellido, int edad, String areaSoporte) {
        super(nombre, apellido, edad);
        this.areaSoporte = areaSoporte;
    }

    @Override
    public void indicarResponsabilidades() {
        super.indicarResponsabilidades();
        System.out.println("Doy soporte técnico en: " + areaSoporte);
    }

    @Override
    public String areaSoporte() {
        return areaSoporte;
    }
}
