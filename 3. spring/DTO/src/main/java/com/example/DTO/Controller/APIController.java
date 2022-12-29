package com.example.DTO.Controller;

import com.example.DTO.Models.Person;
import com.example.DTO.Models.Symptom;
import com.example.DTO.Repository.PersonRepository;
import com.example.DTO.Repository.SymptomRepository;
import com.example.DTO.dto.PersonDTO;
import com.example.DTO.dto.SymptomDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class APIController {
    private SymptomRepository symptomRepository = new SymptomRepository();
    private PersonRepository personRepository = new PersonRepository();
    private ModelMapper modelMapper = new ModelMapper();

    @GetMapping("/findSymptom")
    public List<SymptomDTO> findSymptom() {
        return symptomRepository.getSymptoms().stream().map(s -> modelMapper.map(s, SymptomDTO.class)).collect(Collectors.toList());
    }

    @GetMapping("/findSymptom/{symptom}")
    public List<SymptomDTO> findSymptom(@PathVariable String symptom) {
        return symptomRepository.getSymptoms().stream().filter(s -> s.getName().equals(symptom)).map(s -> modelMapper.map(s, SymptomDTO.class)).collect(Collectors.toList());
    }

    @GetMapping("/findRiskPerson")
    public List<PersonDTO> findRiskPerson() {
        List<Person> riskPeople = personRepository.getPeople().stream().filter(p -> p.getAge() >= 60).collect(Collectors.toList());
        List<PersonDTO> riskPeopleDTO = new ArrayList<>();
        for (Person person : riskPeople) {
            List<Symptom> symptoms = new ArrayList<>();
            for (var symptom : symptomRepository.getSymptoms()) {
                for (int i = 0; i < person.getSymptoms().length; i++) {
                    if (symptom.getCode() == person.getSymptoms()[i]) {
                        symptoms.add(symptom);
                    }
                }
            }
            riskPeopleDTO.add(new PersonDTO(person.getName() + " " + person.getLast_name(), symptoms.stream().map(s->modelMapper.map(s, SymptomDTO.class)).collect(Collectors.toList())));
        }
        return riskPeopleDTO;
    }

}
