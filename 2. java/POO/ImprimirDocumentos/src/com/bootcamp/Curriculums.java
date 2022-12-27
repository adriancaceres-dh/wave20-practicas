package com.bootcamp;

import java.util.ArrayList;
import java.util.List;

public class Curriculums extends Persona implements IImpresora {

    private List<String> habilidades;

    public Curriculums(String nombre, String dni, String telefono, String carrera) {
        super(nombre, dni, telefono, carrera);
        this.habilidades = new ArrayList<>();
    }

    public void agregarHabilidad(String habilidad) {
        habilidades.add(habilidad);
    }
    public List<String> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<String> habilidades) {
        this.habilidades = habilidades;
    }

    public void imprimir() {
        System.out.println("Nombre: " + getNombre() + "\n"
                + "DNI: " + getDni() + "\n"
                + "Teléfono: " + getTelefono() + "\n"
                + "Carrera: " + getCarrera() + "\n"
                + "Habilidades: " + getHabilidades() + "\n");
    }
}
