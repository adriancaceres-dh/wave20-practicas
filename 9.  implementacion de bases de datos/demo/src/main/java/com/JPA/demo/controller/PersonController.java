package com.JPA.demo.controller;

import com.JPA.demo.dto.MessageDTO;
import com.JPA.demo.dto.PersonDTO;
import com.JPA.demo.service.IPersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    final
    IPersonService personService;

    public PersonController(IPersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/create")
    public ResponseEntity<PersonDTO> createPerson(@RequestBody PersonDTO personDTO){
        return ResponseEntity.ok(personService.savePerson(personDTO));
    }

    @GetMapping("/getall")
    public ResponseEntity<List<PersonDTO>> getAllPeople(){
        return ResponseEntity.ok(personService.getAllPeople());
    }

    @GetMapping("/getbyid/{id}")
    public ResponseEntity<PersonDTO> getPersonById(@PathVariable Integer id){
        return ResponseEntity.ok(personService.getPersonById(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<MessageDTO> deletePersonById(@PathVariable Integer id){
        return ResponseEntity.ok(personService.deletePersona(id));
    }
}
