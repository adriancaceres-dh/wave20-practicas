package com.bootcamp._romanos.controller;


import com.bootcamp._romanos.model.NumeroRomano;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControladorRomano {

    @GetMapping("/{numero}")
    public String convertirARomano(@PathVariable Integer numero){
        return NumeroRomano.convertirARomano(numero);
    }
}
