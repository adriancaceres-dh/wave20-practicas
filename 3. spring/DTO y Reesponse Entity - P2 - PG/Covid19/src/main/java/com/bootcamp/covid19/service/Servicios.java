package com.bootcamp.covid19.service;

import com.bootcamp.covid19.dto.GrupoRiesgoDTO;
import com.bootcamp.covid19.model.Persona;
import com.bootcamp.covid19.model.Sintoma;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Servicios {

    List<Persona> personas;
    List<Sintoma> sintomas;

    public Servicios() {
        personas = new ArrayList<>();
        sintomas = new ArrayList<>();
        Sintoma sintoma1 = new Sintoma("1", "Asma", "grave");
        Sintoma sintoma2 = new Sintoma("2", "Bronquitis", "medio");
        Sintoma sintoma3 = new Sintoma("3", "Hipertensión Arterial", "leve");
        sintomas.add(sintoma1);
        sintomas.add(sintoma2);
        sintomas.add(sintoma3);
        Persona persona1 = new Persona(1, "Ronaldo", "Castillo", 65, Arrays.asList(sintoma1, sintoma2, sintoma3));
        Persona persona2 = new Persona(2, "Roberto", "Martinez", 20, Arrays.asList(sintoma1));
        Persona persona3 = new Persona(3, "Ernesto", "Roque", 18, Arrays.asList(sintoma2));
        Persona persona4 = new Persona(4, "Alberto", "Perez", 33, Arrays.asList(sintoma3));
        Persona persona5 = new Persona(5, "Rene", "Maceo", 70, Arrays.asList());
        Persona persona6 = new Persona(6, "Maria", "Rodriguez", 62, Arrays.asList(sintoma1));
        personas.add(persona1);
        personas.add(persona2);
        personas.add(persona3);
        personas.add(persona4);
        personas.add(persona5);
        personas.add(persona6);
    }

    public List<Sintoma> buscarSintomas() {
        return sintomas;
    }

    public ResponseEntity<String> buscarSintomaPorNombre(String nombreSintoma) {
        Sintoma sintoma = sintomas.stream().filter(d -> d.getNombre().equalsIgnoreCase(nombreSintoma)).findFirst().orElse(null);
        if (sintoma != null) {
            return new ResponseEntity<>(sintoma.getNivel_de_gravedad(), HttpStatus.OK);
        }
        return new ResponseEntity<>("No existe el sintoma ingresado.", HttpStatus.BAD_REQUEST);
    }

    public List<GrupoRiesgoDTO> buscarPersonasGrupoRiesgo() {
        return personas.stream().filter(p -> p.getEdad() > 60 && p.getSintomas().size() > 0).collect(Collectors.toList()).stream().map(p -> new GrupoRiesgoDTO(p.getNombre(), p.getApellido(), p.getSintomas().stream().map(s -> s.getNombre()).collect(Collectors.toList()))).collect(Collectors.toList());
    }
}
