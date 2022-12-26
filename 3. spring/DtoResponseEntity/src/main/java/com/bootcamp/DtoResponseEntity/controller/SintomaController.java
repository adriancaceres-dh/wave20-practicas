package com.bootcamp.DtoResponseEntity.controller;

import com.bootcamp.DtoResponseEntity.dto.SintomaDTO;
import com.bootcamp.DtoResponseEntity.model.Sintoma;
import com.bootcamp.DtoResponseEntity.service.SintomaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api")
public class SintomaController {
    private SintomaService sintomaService = new SintomaService();


    @PostMapping("/saveSymptom")
    public ResponseEntity<Object> guadarSintoma(@RequestBody Sintoma sintoma){
        return sintomaService.guardarSintoma(sintoma);
    }
    @GetMapping("/findSymptom")
    public ResponseEntity<Object> listaDeSintomas(){
        return sintomaService.listaDeSintomas();
    }
    @GetMapping("findSymptom/{nombre}")
    public ResponseEntity<Object> encontrarSintoma(@PathVariable String nombre ){
        return sintomaService.encontrarSintoma(nombre);
    }

}
