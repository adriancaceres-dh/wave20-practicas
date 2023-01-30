package com.joyerialasperlas.JojeriaLasPerlas.controller;

import com.joyerialasperlas.JojeriaLasPerlas.model.Joya;
import com.joyerialasperlas.JojeriaLasPerlas.service.IJoyaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JoyaController {
    @Autowired
    IJoyaService joyaService;

    @PostMapping("/jewerly/new")
    public ResponseEntity<String> saveJoya (@RequestBody Joya joya) {
        joyaService.saveJoya(joya);
        return new ResponseEntity("Se guardo  correctamente", HttpStatus.OK);
    }

    @GetMapping("/jewerly")
    public List<Joya> getJoyas () {

        return joyaService.getJoyas();
    }

    @PutMapping("/jewerly/delete/{id}")
    public ResponseEntity<String> deleteJoya (@PathVariable Long id) {


        joyaService.deleteJoya(id);
        return new ResponseEntity("Se borro  correctamente", HttpStatus.OK);
    }

    @PutMapping ("/jewerly/update/{id}")
    public ResponseEntity<String> editJoya (@PathVariable Long id,
                            @RequestBody Joya joya) {

        joyaService.updateJoya(id,joya);
        return new ResponseEntity("Se hizo update  correctamente", HttpStatus.OK);
    }
}
