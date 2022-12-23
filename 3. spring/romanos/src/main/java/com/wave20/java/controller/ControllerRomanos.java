package com.wave20.java.controller;

import com.wave20.java.service.Romano;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ControllerRomanos {


    @GetMapping("/{nombre}")
    public String saludar(@PathVariable String nombre) {
        return "HOLA " + nombre;
    }

    @GetMapping("romano/{numero}")
    public String numeroRomano(@PathVariable Integer numero) {

        return Romano.romanize(numero);
    }


}
