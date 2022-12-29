package com.covid19.covid19.controller;

import com.covid19.covid19.model.Sintoma;
import com.covid19.covid19.service.SintomaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class SintomasController {

    @Autowired
    SintomaService sintomaService;

    @GetMapping("/findSymtom")
    public List<Sintoma> getTodosSintomas(){
        return sintomaService.findTodos();
    }
    @GetMapping("/findSymtom/{name}")
    public ResponseEntity<Sintoma> getSintoma(@PathVariable String name){
       Sintoma sintoma = sintomaService.findByName(name);
       if (sintoma==null){
           return ResponseEntity.notFound().build();
       }else{
           return new ResponseEntity(sintoma, HttpStatus.FOUND);
       }
    }

}
