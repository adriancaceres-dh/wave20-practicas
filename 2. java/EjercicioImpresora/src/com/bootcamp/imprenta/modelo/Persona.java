package com.bootcamp.imprenta.modelo;

public class Persona {
    private String nombre;
    private String apellido;
    private String rol;

    public Persona() {
    }
    public Persona(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Persona(String nombre, String apellido, String rol) {
        this(nombre,apellido);
        this.rol = rol;
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

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        if(this.rol != null){
            return  nombre + ' '+ apellido+ " con rol de "+rol ;
        }
        return  nombre + ' '+ apellido ;
    }
}
