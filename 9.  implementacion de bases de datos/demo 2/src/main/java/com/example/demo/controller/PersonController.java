package com.example.demo.controller;

import com.example.demo.dto.MessageDto;
import com.example.demo.dto.PersonDto;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    PersonService personService;

    @PostMapping("/add")
    public ResponseEntity<PersonDto> add(@RequestBody PersonDto dto) {
        return ResponseEntity.ok(personService.saveEntity(dto));
    }

    @GetMapping
    public ResponseEntity<List<PersonDto>> getAll() {
        return ResponseEntity.ok(personService.getAllEntities());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<MessageDto> delete(@PathVariable Integer id) {
        return ResponseEntity.ok(personService.deleteEntity(id));
    }
}
