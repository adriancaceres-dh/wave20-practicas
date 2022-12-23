package com.bootcamp.Hospital.controller;

import com.bootcamp.Hospital.model.Sintoma;
import com.bootcamp.Hospital.response.ResponseEntity;
import com.bootcamp.Hospital.service.SintomaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sintoma")
public class SintomaController {

    private SintomaService sintomaService = new SintomaService();

    @PostMapping("/saveSymptom")
    public ResponseEntity<Sintoma> saveSymptom(@RequestBody Sintoma sintoma){
        return sintomaService.saveSymptom(sintoma);
    }

    @GetMapping("findAllSymptom")
    public ResponseEntity<List<Sintoma>> findAllSymptom(){
        return sintomaService.findAllSymptom();
    }

    @GetMapping("/findSymptom")
    public ResponseEntity<Sintoma> findSymptom(@RequestParam String nombre){
        return sintomaService.findSymptom(nombre);
    }
}
