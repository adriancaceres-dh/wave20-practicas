package com.dto.covid.controller;

import com.dto.covid.service.SymptomS;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("findSymptom")
public class SymptomC {

    SymptomS symptomSerivce;

    public SymptomC() {
        symptomSerivce = new SymptomS();
    }

    @GetMapping
    public String getAllSymptoms() {
        return symptomSerivce.printList();
    }

    @GetMapping("{name}")
    public ResponseEntity<String> getSymptomByName (@PathVariable String name){
        return new ResponseEntity<>(symptomSerivce.findOneByName(name), HttpStatus.OK);
    }
}
