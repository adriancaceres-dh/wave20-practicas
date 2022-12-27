package com.bootcamp.clases;

import com.bootcamp.interfaces.IDarMantenimiento;

public class PersonalMantenimiento extends Persona implements IDarMantenimiento {

    private String areaAMantener;

    public PersonalMantenimiento(String nombre, String dni, String tel, String areaAMantener) {
        super(nombre, dni, tel);
        this.areaAMantener = areaAMantener;
    }

    public String getAreaAMantener() {
        return areaAMantener;
    }

    public void setAreaAMantener(String areaAMantener) {
        this.areaAMantener = areaAMantener;
    }

    @Override
    public void mantengo() {
        System.out.println("Doy mantenimiento al área de: " + this.areaAMantener);
    }
}
