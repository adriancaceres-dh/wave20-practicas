package com.bootcamp.model;

public class Personal extends Persona {
    private String area;

    public Personal() {
    }

    public Personal(int id, String nombre, String area) {
        super(id, nombre);
        this.area = area;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
