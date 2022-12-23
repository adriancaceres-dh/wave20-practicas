package com.pruebas.PruebasSpringBoot.services;


import com.pruebas.PruebasSpringBoot.dto.DeporteDto;
import com.pruebas.PruebasSpringBoot.dto.PersonaDto;
import lombok.Builder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeportesServices {


    List<DeporteDto> deporteDtos = new ArrayList<>();
    List<PersonaDto> personaDtos = new ArrayList<>();

    public DeportesServices() {
        deporteDtos.add(DeporteDto.builder().nombre("Futbol").nivel("Amateur").build());
        deporteDtos.add(DeporteDto.builder().nombre("Bascket").nivel("Basico").build());
        deporteDtos.add(DeporteDto.builder().nombre("Voley").nivel("Profesional").build());
        deporteDtos.add(DeporteDto.builder().nombre("Natacion").nivel("Legendario").build());

        personaDtos.add(PersonaDto.builder().nombre("Brayan").apellido("Perez").nombreDeporte(deporteDtos.get(0).getNombre()).build());
        personaDtos.add(PersonaDto.builder().nombre("Juan").apellido("Mosquera").nombreDeporte(deporteDtos.get(1).getNombre()).build());
        personaDtos.add(PersonaDto.builder().nombre("Pepito").apellido("Sanchez").nombreDeporte(deporteDtos.get(2).getNombre()).build());
        personaDtos.add(PersonaDto.builder().nombre("Maria").apellido("Ortiz").nombreDeporte(deporteDtos.get(3).getNombre()).build());
    }



    public List<DeporteDto> findAllSports(){
        return deporteDtos;
    }

    public DeporteDto findSports(String name){
        return deporteDtos.stream().filter(d-> d.getNombre().equals(name)).findFirst().get();
    }


    public List<PersonaDto> findSportsPerson(){
        return personaDtos;

    }
}
