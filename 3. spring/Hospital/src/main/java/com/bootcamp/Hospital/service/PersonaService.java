package com.bootcamp.Hospital.service;

import com.bootcamp.Hospital.dto.SintomaDto;
import com.bootcamp.Hospital.model.Persona;
import com.bootcamp.Hospital.model.Sintoma;
import com.bootcamp.Hospital.repository.PersonaRepository;
import com.bootcamp.Hospital.response.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PersonaService {

    private PersonaRepository personaRepository;

    public PersonaService(){
        personaRepository = new PersonaRepository();
    }

    public ResponseEntity<Persona> savePerson(Persona persona){
        try {
            Persona personaEncontrada = personaRepository.findPerson(persona.getId());
            if (personaEncontrada != null) new ResponseEntity<Persona>(
                    "La persona ya se encuentra registrada con los siguientes datos", false, personaEncontrada);
            return new ResponseEntity<Persona>("Persona guardada correctamente", false, personaRepository.savePerson(persona));
        }catch (Exception e){
            return new ResponseEntity<Persona>("Ha surgido un error: "+e.getMessage(),true, null);
        }
    }

    public ResponseEntity<List<SintomaDto>> findAllPerson(){
        try {

            List<Persona> personas = personaRepository.consultarPersonas();

            List<SintomaDto> sintomasDto = personas.stream().map(p -> new SintomaDto(p)).collect(Collectors.toList());

            return new ResponseEntity<List<SintomaDto>>("Consulta realizada con exito", false, sintomasDto);
        }catch (Exception e){
            return new ResponseEntity<List<SintomaDto>>("Ha surgido un error: "+e.getMessage(), true, null);
        }
    }



    public ResponseEntity<Persona> findPerson(String id){
        return new ResponseEntity<Persona>("Holis", false, personaRepository.findPerson(id));
    }

}
