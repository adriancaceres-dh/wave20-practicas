package com.bootcamp.DtoResponseEntity.service;

import com.bootcamp.DtoResponseEntity.model.Persona;
import com.bootcamp.DtoResponseEntity.model.Sintoma;
import com.bootcamp.DtoResponseEntity.repository.PersonaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class PersonaService {
    private PersonaRepository personaRepository;

    public PersonaService() {
        personaRepository = new PersonaRepository();
    }

    public ResponseEntity<Object> guardarPersona(Persona persona){
        try {
            personaRepository.guardarPersona(persona);
            return  new ResponseEntity<>("Persona guardado correctamente",HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.FORBIDDEN);
        }
    }
public ResponseEntity<Object> listaDePeronas(){

    List<Persona> personaList = personaRepository.listaDePersonas();

        try {
            return  new ResponseEntity<>(personaList ,HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.FORBIDDEN);
        }

}
    public ResponseEntity<Object> listaDePersonasConSintoma(String nombre){

        try {
            personaRepository.listaPersonaConSintoma(nombre);
            return new ResponseEntity<>("Lista de personas", HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.FORBIDDEN);
        }
    }


}
