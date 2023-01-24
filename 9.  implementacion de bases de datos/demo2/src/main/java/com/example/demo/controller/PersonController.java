package com.example.demo.controller;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {
  private final PersonService personService;

  public PersonController(PersonService personService) {
    this.personService = personService;
  }

  @PostMapping("/")
  public Person createPerson(@RequestBody Person person) {
    return personService.createPerson(person);
  }

  @GetMapping("/")
  public List<Person> findAllPeople() {
    return personService.getAllPeople();
  }

  @GetMapping("/id/{id}")
  public Person findById(@PathVariable int id) {
    return personService.getById(id);
  }
}
