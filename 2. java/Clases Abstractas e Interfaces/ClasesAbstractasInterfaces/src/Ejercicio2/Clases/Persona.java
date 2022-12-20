package Ejercicio2.Clases;

import java.util.List;

public class Persona {
    private String nombre;
    private List<String> habilidades;

    public Persona(String nombre, List<String> habilidades) {
        this.nombre = nombre;
        this.habilidades = habilidades;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<String> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<String> habilidades) {
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
