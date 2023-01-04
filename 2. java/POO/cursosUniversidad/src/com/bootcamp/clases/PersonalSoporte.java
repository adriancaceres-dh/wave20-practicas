package com.bootcamp.clases;

import com.bootcamp.interfaces.IDarSoporte;

public class PersonalSoporte extends Persona implements IDarSoporte {

    private String areaSoporte;

    public PersonalSoporte(String nombre, String dni, String tel, String areaSoporte) {
        super(nombre, dni, tel);
        this.areaSoporte = areaSoporte;
    }

    public String getAreaSoporte() {
        return areaSoporte;
    }

    public void setAreaSoporte(String areaSoporte) {
        this.areaSoporte = areaSoporte;
    }

    @Override
    public void darSoporte() {
        System.out.println("Doy soporte en el área de: " + this.areaSoporte);
    }
}
