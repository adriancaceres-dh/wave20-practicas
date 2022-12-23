package com.bootcamp.Hospital.service;

import com.bootcamp.Hospital.model.Persona;
import com.bootcamp.Hospital.repository.PersonaRepository;
import com.bootcamp.Hospital.response.ResponseEntity;

import java.util.List;

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

    public ResponseEntity<List<Persona>> findAllPerson(){
        try {
            return new ResponseEntity<List<Persona>>("Consulta realizada con exito", false, personaRepository.consultarPersonas());
        }catch (Exception e){
            return new ResponseEntity<List<Persona>>("Ha surgido un error: "+e.getMessage(), true, null);
        }
    }



}
