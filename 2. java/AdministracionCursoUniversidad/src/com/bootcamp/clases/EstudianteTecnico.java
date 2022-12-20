package com.bootcamp.clases;

import com.bootcamp.interfaces.DarSoporteTecnicoInterface;

public class EstudianteTecnico extends Estudiante implements DarSoporteTecnicoInterface {

    private String areaSoporte;

    public EstudianteTecnico(String nombre, String apellido, int edad, String areaSoporte) {
        super(nombre, apellido, edad);
        this.areaSoporte = areaSoporte;
    }

    @Override
    public void indicarResponsabilidades() {
        super.indicarResponsabilidades();
        System.out.println("Doy también soporte técnico en: " + areaSoporte);
    }

    @Override
    public String areaSoporte() {
        return areaSoporte;
    }
}
