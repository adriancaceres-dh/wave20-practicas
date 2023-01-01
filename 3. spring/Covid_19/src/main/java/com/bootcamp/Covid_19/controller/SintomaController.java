package com.bootcamp.Covid_19.controller;

import com.bootcamp.Covid_19.dto.SintomaDTO;
import com.bootcamp.Covid_19.services.SintomaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SintomaController {

    @Autowired
    SintomaService sintomaService;
    @GetMapping("/findSympton")
    public ResponseEntity<List<SintomaDTO>> getSintomas(){
        return new ResponseEntity<>(sintomaService.getSintomas(), HttpStatus.OK);
    }

    @GetMapping("/findSympton/{name}")
    public ResponseEntity<String> getGravedadByName(@PathVariable String name){

        return  new ResponseEntity<>(sintomaService.getSintomaByName(name), HttpStatus.OK);
    }
}
