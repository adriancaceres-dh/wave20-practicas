package com.spring.covid19.controller;

import com.spring.covid19.dto.SintomaDTO;
import com.spring.covid19.model.Sintoma;
import com.spring.covid19.service.SintomaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.List;

@RestController
public class SintomasController {

    @GetMapping("/findSymptoms")
    public ResponseEntity<List<SintomaDTO>> encontrarSintomas(){
        return ResponseEntity.ok().body(SintomaService.obtenerTodosSintomas());

    }

    @GetMapping("/findSymptom")
    public ResponseEntity<Integer> encontrarSintoma(@RequestParam String nombre){
        Integer nivelGravedad = SintomaService.encontrarSintoma(nombre);
        if(nivelGravedad == -1)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return ResponseEntity.ok(nivelGravedad);
    }
}
