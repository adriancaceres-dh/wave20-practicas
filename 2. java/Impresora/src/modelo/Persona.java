package modelo;

import java.util.ArrayList;
import java.util.Arrays;

public class Persona {
    private String nombre;
    private ArrayList habilidades;

    public Persona(String nombre, ArrayList habilidades) {
        this.nombre = nombre;
        this.habilidades = habilidades;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(ArrayList habilidades) {
        this.habilidades = habilidades;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", habilidades=" + habilidades +
                '}';
    }
}
