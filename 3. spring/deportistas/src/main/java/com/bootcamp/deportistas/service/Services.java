package com.bootcamp.deportistas.service;

import com.bootcamp.deportistas.dto.PersonaDTO;
import com.bootcamp.deportistas.model.Deporte;
import com.bootcamp.deportistas.model.Persona;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class Services {

    private List<Persona> personas;
    private List<Deporte> deportes;

    public Services() {
        this.personas = new ArrayList<>();
        this.deportes = new ArrayList<>();

        Deporte futbol = new Deporte("Futbol", "alto");
        Deporte tenis = new Deporte("Tenis", "alto");

        Persona persona1 = new Persona("Nombre1", "Apellido1", 20, futbol);
        Persona persona2 = new Persona("Nombre2", "Apellido2", 25, null);

        personas.add(persona1);
        personas.add(persona2);
        deportes.add(futbol);
        deportes.add(tenis);
    }

    public List<Deporte> obtenerDeportes(){
        return this.deportes;
    }

    public String obtenerDeporteNivel(String nombre){
        Optional<Deporte> deporteBuscado = this.deportes.stream().filter(d -> d.getNombre().toLowerCase().equals(nombre.toLowerCase())).findFirst();
        if(deporteBuscado.isPresent()) return deporteBuscado.get().getNivel();
        return null;
    }

    public List<PersonaDTO> obtenerDeportistas(){
        List<Persona> deportistas = this.personas.stream().filter(p -> p.getDeporteRealizado() != null).collect(Collectors.toList());
        List<PersonaDTO> deportistasDTO = deportistas.stream().map(d -> new PersonaDTO(d.getNombre(), d.getApellido(), d.getDeporteRealizado().getNombre())).collect(Collectors.toList());
        return deportistasDTO;
    }


}
