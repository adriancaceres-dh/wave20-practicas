package com.wave20.ejercicio_deportistas.DTO;

public class PersonaDeporteDTO {

    private final String nombre;
    private final String apellido;
    private final String nivel;

    public PersonaDeporteDTO(String nombre, String apellido, String nivel) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nivel = nivel;
    }

    public String getNombre() {
        return nombre;
    }



    public String getApellido() {
        return apellido;
    }



    public String getNivel() {
        return nivel;
    }


}
