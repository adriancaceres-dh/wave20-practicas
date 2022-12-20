package com.bootcamp;

import java.util.ArrayList;
import java.util.List;

public class Curriculums implements IDescripcion {

    private String nombre;
    private String profesion;

    private List<String>  habilidades= new ArrayList();

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public List<String> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<String> habilidades) {
        this.habilidades = habilidades;
    }

    @Override
    public void mostrar() {
        System.out.println("Nombre es: "+ nombre + " Profesion es: " + profesion + " Sus habilidades son: "+habilidades);
    }
}
