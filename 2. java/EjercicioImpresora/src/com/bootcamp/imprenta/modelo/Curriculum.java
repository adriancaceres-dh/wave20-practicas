package com.bootcamp.imprenta.modelo;

import java.util.ArrayList;
import java.util.List;

public class Curriculum extends Hoja implements IImprimible {
    private Persona persona;
    private Carrera carrera;
    private List<String> habilidades;

    public Curriculum(Persona persona, Carrera carrera, String contenido) {
        super(contenido);
        this.persona = persona;
        this.carrera = carrera;
        this.habilidades = new ArrayList<>();
    }

    public Curriculum addExperiencia(String nuevaHabilidad){
        habilidades.add(nuevaHabilidad);
        return this;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }


    @Override
    public String imprimir() {
        StringBuilder sb = new StringBuilder("Nombre:");
        sb.append(persona).append("\n")
                .append("Resumen: ").append(this.contenido)
                .append("\n").append("Profesión ")
                .append(this.carrera.getNombre()).append("\n")
                .append("Habilidades: \n");
        for(String habilidad: habilidades){
            sb.append("- ").append(habilidad).append("\n");
        }
        return sb.toString();
    }
}
