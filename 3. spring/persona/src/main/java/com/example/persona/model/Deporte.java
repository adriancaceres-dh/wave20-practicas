package com.example.persona.model;

import com.example.persona.model.enums.NivelEnum;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



public class Deporte {
    private int Id;
    private String Nombre;
    private NivelEnum Nivel;

    public Deporte(int id, String nombre, NivelEnum nivel) {
        Id = id;
        Nombre = nombre;
        Nivel = nivel;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public NivelEnum getNivel() {
        return Nivel;
    }

    public void setNivel(NivelEnum nivel) {
        Nivel = nivel;
    }
}
