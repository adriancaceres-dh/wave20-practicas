package com.example.sintomas.controllers;

import com.example.sintomas.dtos.SintomaDto;
import com.example.sintomas.services.SintomaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/Symptom")
public class SintomaController {
    public static SintomaService _service = new SintomaService();
    @GetMapping("/findSymptom")
    public Collection<SintomaDto> GetSintomas(){
        return _service.getAll();
    }

    @GetMapping("/findSymptom/{name}")
    public SintomaDto GetSintomas(@PathVariable String name){
        return _service.getByName(name);
    }
}
