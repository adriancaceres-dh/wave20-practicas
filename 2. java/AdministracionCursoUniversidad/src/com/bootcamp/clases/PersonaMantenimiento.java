package com.bootcamp.clases;

import com.bootcamp.interfaces.MantenerInterface;

public class PersonaMantenimiento extends Persona implements MantenerInterface {

    private String areaMantenimiento;

    public PersonaMantenimiento(String nombre, String apellido, int edad, String areaMantenimiento) {
        super(nombre, apellido, edad);
        this.areaMantenimiento = areaMantenimiento;
    }

    @Override
    public void indicarResponsabilidades() {
        super.indicarResponsabilidades();
        System.out.println("Doy mantenimiento en : " + areaMantenimiento);
    }

    @Override
    public String areaMantenimiento() {
        return areaMantenimiento;
    }
}
