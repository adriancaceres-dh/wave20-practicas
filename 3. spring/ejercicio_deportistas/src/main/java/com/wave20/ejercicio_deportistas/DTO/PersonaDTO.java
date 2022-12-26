package com.wave20.ejercicio_deportistas.DTO;

public class PersonaDTO {

    private final String nombre;
    private final String apellido;
    private final int edad;

    public PersonaDTO(String nombre, String apellido, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }



    public String getApellido() {
        return apellido;
    }



    public int getEdad() {
        return edad;
    }


}
