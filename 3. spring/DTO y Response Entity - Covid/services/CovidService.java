package com.bootcamp.test.services;

import com.bootcamp.test.dtos.PersonaDTO;
import com.bootcamp.test.dtos.SintomaDTO;
import com.bootcamp.test.model.NivelDeGravedad;
import com.bootcamp.test.model.Persona;
import com.bootcamp.test.model.Sintoma;
import com.bootcamp.test.repository.CovidRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class CovidService {

    public static List<SintomaDTO> getAllSintomas() {
        List<Sintoma> allSymptoms = CovidRepository.listaSintomas;
        List<SintomaDTO> symptomsDTOList = new ArrayList<>();
        for (var symptom: allSymptoms) {
            symptomsDTOList.add(new SintomaDTO(symptom.getNombre(), symptom.getNivelDeGravedad().toString()));
        }
        return symptomsDTOList;
    }

    public static NivelDeGravedad getNivelDeGravedad(String name) {
        List<Sintoma> sintomas = CovidRepository.listaSintomas;
        return sintomas.stream().filter(sintoma -> Objects.equals(sintoma.getNombre(), name))
                .findFirst().get().getNivelDeGravedad();
    }

    public static List<PersonaDTO> getPersonasDeRiesgo() {
        List<Persona> personas = CovidRepository.listaPersonas;
        List<PersonaDTO> personaDTOList = new ArrayList<>();
        for (var persona : personas) {
            if (persona.getEdad() >= 60) {
                personaDTOList.add(new PersonaDTO(persona.getNombre(), persona.getApellido()));
            }
        }
        return personaDTOList;
    }
}
