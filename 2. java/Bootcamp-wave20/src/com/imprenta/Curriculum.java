package com.imprenta;

import java.util.ArrayList;
import java.util.List;

public class Curriculum implements Documento {

    private String nombre;
    private String dni;
    private String telefono;
    private List<String> habilidades = new ArrayList<>();

    public Curriculum(String nombre, String dni, String telefono, List<String> habilidades) {
        this.nombre = nombre;
        this.dni = dni;
        this.telefono = telefono;
        this.habilidades = habilidades;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<String> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<String> habilidades) {
        this.habilidades = habilidades;
    }
}
