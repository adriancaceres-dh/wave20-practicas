package com.bootcamp.covid.controller;

import com.bootcamp.covid.dto.PersonaDTO;
import com.bootcamp.covid.model.NivelDeGravedad;
import com.bootcamp.covid.model.Persona;
import com.bootcamp.covid.model.Sintoma;
import com.bootcamp.covid.repository.factory.RepositoryFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SymptomController {

    @GetMapping("/findSymptom")
    public List<Sintoma> sintomas() {
        return RepositoryFactory.get(Sintoma.class).getAll();
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<NivelDeGravedad> nivelDeGravedad(@PathVariable String name) {
        var repository = RepositoryFactory.get(Sintoma.class);
        var maybeSymptom = repository.find(s -> s.getNombre().equals(name));

        return maybeSymptom
                .map(sintoma -> ResponseEntity.ok(sintoma.getNivelDeGravedad()))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @GetMapping("/findRiskPerson")
    public List<PersonaDTO> findRiskGroup() {
        var riskPeople = RepositoryFactory.get(Persona.class).findAll(p -> p.getEdad() > 60);
        var symptoms = RepositoryFactory.get(Sintoma.class).getAll();
        List<PersonaDTO> personasDTO = new ArrayList<>();

        for (Persona persona : riskPeople) {
            personasDTO.add(new PersonaDTO(persona, symptoms));
        }

        return personasDTO;
    }

}
