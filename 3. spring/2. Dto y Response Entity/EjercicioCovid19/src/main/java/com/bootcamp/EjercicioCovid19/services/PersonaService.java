package com.bootcamp.EjercicioCovid19.services;

import com.bootcamp.EjercicioCovid19.DTOs.PersonaDto;
import com.bootcamp.EjercicioCovid19.repositories.PersonaRepository;
import com.bootcamp.EjercicioCovid19.repositories.SintomaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonaService {
    @Autowired
    private PersonaRepository personaRepository;
    @Autowired
    private SintomaRepository sintomaRepository;

    public List<PersonaDto> getListadoRiesgo (){
        List<PersonaDto> listaRiesgo = new ArrayList<>();

        this.personaRepository.getListaPersonas().stream().forEach(
                persona -> {
                    if (persona.getEdad()>60){
                        List<String> sintomas = new ArrayList<>();
                        sintomaRepository.getSintomas().stream().forEach(sintoma -> sintomas.add(sintoma.getNombre()));
                        listaRiesgo.add(new PersonaDto(persona.getNombre(),persona.getApellido(),sintomas));
                    }
                });
        return listaRiesgo;
    }
}
