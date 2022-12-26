package com.ejercicio.Covid19.model;

public class Persona {

    private int id;
    private String nombre;
    private String apelliedo;
    private int edad;

    private Sintoma sintoma;

    public Persona(int id, String nombre, String apelliedo, int edad,Sintoma sintoma) {
        this.id = id;
        this.nombre = nombre;
        this.apelliedo = apelliedo;
        this.edad = edad;
        this.sintoma = sintoma;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApelliedo() {
        return apelliedo;
    }

    public void setApelliedo(String apelliedo) {
        this.apelliedo = apelliedo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Sintoma getSintoma() {
        return sintoma;
    }

    public void setSintoma(Sintoma sintoma) {
        this.sintoma = sintoma;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apelliedo='" + apelliedo + '\'' +
                ", edad=" + edad +
                ", sintoma=" + sintoma +
                '}';
    }
}
