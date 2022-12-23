package com.example.deportistas.servicio;

import com.example.deportistas.dto.DeportistaDTO;
import com.example.deportistas.model.Deporte;
import com.example.deportistas.model.Persona;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Deportistas {
    List<Deporte> deportes;
    List<Persona> personas;

    public Deportistas() {
        personas=new ArrayList<>();
        deportes=new ArrayList<>();

        Deporte deporte1=new Deporte("futbol","principiante");
        Deporte deporte2=new Deporte("tenis","principiante");
        Deporte deporte3=new Deporte("baloncesto","avanzado");

        Persona persona1=new Persona("David","Quintero", 32,deporte1);
        Persona persona2=new Persona("Pedro","Quintero", 24,deporte2);

        personas.add(persona1);
        personas.add(persona2);
        deportes.add(deporte1);
        deportes.add(deporte2);
        deportes.add(deporte3);

    }

    public List<Deporte> buscarDeportes(String deporte){
        if(deporte==null) return deportes;
        return deportes.stream().filter(d-> d.getNombre().equals(deporte)).collect(Collectors.toList());
    };

    public List<DeportistaDTO> buscarPersonas(){
        List<DeportistaDTO> deportistaDTOS=new ArrayList<>();
        for (Persona persona :personas) {
            DeportistaDTO nuevaPersona = new DeportistaDTO();
            nuevaPersona.setNombre(persona.getNombre());
            nuevaPersona.setApellido(persona.getApellido());
            nuevaPersona.setDeporte(persona.getDeporte().getNombre());
            deportistaDTOS.add(nuevaPersona);
        }
        return deportistaDTOS;
    }
}
