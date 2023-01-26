package com.JPA.demo.controller;

import com.JPA.demo.dto.MessageDTO;
import com.JPA.demo.dto.PersonDTO;
import com.JPA.demo.entity.Client;
import com.JPA.demo.entity.Person;
import com.JPA.demo.service.interfaces.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("person")
public class PersonController {

    @Autowired
    IPersonService personService;

    @PostMapping("/")
    public ResponseEntity<PersonDTO> create(@RequestBody PersonDTO personDTO){
        return ResponseEntity.ok(personService.saveEntity(personDTO));
    }

    @GetMapping("/")
    public ResponseEntity<List<PersonDTO>> getAll(){
        return ResponseEntity.ok(personService.getAllEntities());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonDTO> getById(@PathVariable Integer id){
        return ResponseEntity.ok(personService.getEntityById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageDTO> deleteById(@PathVariable Integer id){
        return ResponseEntity.ok(personService.deleteEntity(id));
    }

    @GetMapping("/prueba/")
    public ResponseEntity<Double> metodoPrueba(){
        return ResponseEntity.ok(personService.findby());
    }
}
