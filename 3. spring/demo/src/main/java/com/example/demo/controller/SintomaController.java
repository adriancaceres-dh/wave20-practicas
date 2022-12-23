package com.example.demo.controller;

import com.example.demo.model.Sintoma;
import com.example.demo.service.SintomaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SintomaController {
    SintomaService sintomaService = new SintomaService();

    @GetMapping("/findSymptom")
    @ResponseBody
    public List<Sintoma> findSymptom(){
        return sintomaService.getSintomaList();
    }

    @GetMapping("/findSymptom/{sintoma}")
    //@ResponseBody
    public ResponseEntity<String> findSymptom(@PathVariable String sintoma){
        return new ResponseEntity<>(sintomaService.findSymptomByName(sintoma).getNivel_de_gravedad(), HttpStatus.OK);
    }

}
