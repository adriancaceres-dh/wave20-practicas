package com.bootcamp.ejemploJPA.controller;

import com.bootcamp.ejemploJPA.entity.Person;
import com.bootcamp.ejemploJPA.repository.IPersonRepository;
import com.bootcamp.ejemploJPA.service.IPersonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    private final IPersonService personService;


    public PersonController(IPersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/")
    public Person createPerson(@RequestBody Person person){
        return personService.createPerson(person);
    }

    @GetMapping("/")
    public List<Person> getAllPeople(){
        return personService.getAllPeople();
    }

    @GetMapping("/id/{id}")
    public Person getPersonById(@PathVariable Integer id){
        return personService.getById(id);
    }

    @DeleteMapping("/{id}")
    public Integer deleteById(@PathVariable Integer id){
        return personService.deletePerson(id);
    }
}
