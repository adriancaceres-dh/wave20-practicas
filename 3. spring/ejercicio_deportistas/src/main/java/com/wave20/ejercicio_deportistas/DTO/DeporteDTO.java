package com.wave20.ejercicio_deportistas.DTO;

public class DeporteDTO {

    private final String nombre;
    private final String nivel;

    public DeporteDTO(String nombre, String nivel) {
        this.nombre = nombre;
        this.nivel = nivel;
    }

    public String getNombre() {
        return nombre;
    }



    public String getNivel() {
        return nivel;
    }


}
