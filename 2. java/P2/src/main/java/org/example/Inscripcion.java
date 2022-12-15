package org.example;

public class Inscripcion {
    private int dni;
    private int numInscripcion;
    private int circuito;
    private String nombre;
    private String apellido;
    private int edad;
    private String celular;

    public Inscripcion(int dni, int numInscripcion, int circuito, String nombre, String apellido, int edad, String celular) {
        this.dni = dni;
        this.numInscripcion = numInscripcion;
        this.circuito = circuito;

        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.celular = celular;
    }

    public int getNumInscripcion() {
        return numInscripcion;
    }

    public void setNumInscripcion(int numInscripcion) {
        this.numInscripcion = numInscripcion;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public int getCircuito() {
        return circuito;
    }

    public void setCircuito(int circuito) {
        this.circuito = circuito;
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

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }
}
