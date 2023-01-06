package com.bootcamp.entidad_de_salud.services;

import com.bootcamp.entidad_de_salud.dto.PersonaDto;
import com.bootcamp.entidad_de_salud.models.Persona;
import com.bootcamp.entidad_de_salud.models.Relacion;
import com.bootcamp.entidad_de_salud.models.Sintoma;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class Services {

    private List<Persona> personas;
    private List<Sintoma> sintomas;
    private List<Relacion> relaciones;

    public Services(){
        personas = new ArrayList<>();
        sintomas = new ArrayList<>();
        relaciones = new ArrayList<>();

        Persona persona1 = new Persona(1,"nombre1", "apellido1", 65);
        Persona persona2 = new Persona(2,"nombre2", "apellido2", 20);
        Persona persona3 = new Persona(3,"nombre3", "apellido3", 70);
        Persona persona4 = new Persona(4,"nombre4", "apellido4", 70);

        Sintoma sintoma1 = new Sintoma(1, "tos", 1);

        Relacion relacion1 = new Relacion(persona1.getId(), sintoma1.getCodigo());
        Relacion relacion2 = new Relacion(persona2.getId(), sintoma1.getCodigo());
        Relacion relacion3 = new Relacion(persona3.getId(), sintoma1.getCodigo());

        personas.add(persona1);
        personas.add(persona2);
        personas.add(persona3);
        personas.add(persona4);
        sintomas.add(sintoma1);
        relaciones.add(relacion1);
        relaciones.add(relacion2);
        relaciones.add(relacion3);
    }

    public List<Sintoma> obtenerSintomas(){
        return this.sintomas;
    }

    public String obtenerGravedadDelSintoma(String nombre){
        Optional<Sintoma> sintomaBuscado = this.sintomas.stream().filter(s -> s.getNombre().toLowerCase().equals(nombre.toLowerCase())).findFirst();
        if(sintomaBuscado.isPresent()){
            return "Gravedad del sintoma: " + sintomaBuscado.get().getNivel_de_gravedad();
        }
        return null;
    }

    public List<PersonaDto> grupoDeRiesgo(){
        List<Persona> mayoresDe60 = personas.stream().filter(p -> p.getEdad() > 60).collect(Collectors.toList());
        List<Persona> personasDeRiesgo = mayoresDe60.stream().filter(p -> relaciones.stream().anyMatch(r -> r.getIdPersona() == p.getId())).collect(Collectors.toList());
        List<PersonaDto> personasDto = personasDeRiesgo.stream().map(p -> new PersonaDto(p.getNombre(), p.getApellido())).collect(Collectors.toList());
        return personasDto;
    }
}
