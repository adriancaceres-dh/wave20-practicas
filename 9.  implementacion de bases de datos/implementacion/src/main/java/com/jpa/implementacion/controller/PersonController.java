package com.jpa.implementacion.controller;

import com.jpa.implementacion.dto.PersonDto;
import com.jpa.implementacion.service.IPersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {

    private final IPersonService personService;

    public PersonController(IPersonService personService) {
        this.personService = personService;
    }

    @GetMapping("all")
    public ResponseEntity<List<PersonDto>> getAll(){
        return ResponseEntity.ok(personService.getAll());
    }

    @GetMapping("/")
    public ResponseEntity<Long> count(){
        return ResponseEntity.ok(personService.countPerson());
    }

    @PostMapping("/create")
    public ResponseEntity<PersonDto> createPerson(@RequestBody PersonDto personDto){
        return ResponseEntity.ok(personService.savePerson(personDto));
    }

}
