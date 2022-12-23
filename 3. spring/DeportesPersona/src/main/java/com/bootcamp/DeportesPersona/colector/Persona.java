package com.bootcamp.DeportesPersona.colector;

import java.util.HashMap;
import java.util.Map;

public class Persona {

    String nombre;
    String apellido;

    int edad;

    public Persona(String nombre, String apellido, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                '}';
    }

    public Map<String, String> practica(String nombre, String deporte){

        Map<String, String> relacion= new HashMap<>();
        relacion.put(nombre,deporte);

        return relacion;

    }
}
