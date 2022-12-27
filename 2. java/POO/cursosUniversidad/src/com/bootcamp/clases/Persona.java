package com.bootcamp.clases;

public class Persona {
    private String nombre;
    private String dni;
    private String tel;

    public Persona(String nombre, String dni, String tel) {
        this.nombre = nombre;
        this.dni = dni;
        this.tel = tel;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
