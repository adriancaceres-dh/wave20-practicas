package com.bootcamp.Covid19.controller;

import com.bootcamp.Covid19.service.SintomaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/findSymptom")
public class SintomaController {

    private SintomaService sintomaService;

    public SintomaController(){

        sintomaService = new SintomaService();
    }

    @GetMapping()
    public ResponseEntity<List<String>> sintomas (){
        return new ResponseEntity<>(sintomaService.encontrarSintomas(), HttpStatus.OK);
    }

    @GetMapping("/{sintoma}")
    public ResponseEntity<String> sintoma(@PathVariable String sintoma){
        return new ResponseEntity<>(sintomaService.encontrarSintoma(sintoma), HttpStatus.OK);
    }
}
