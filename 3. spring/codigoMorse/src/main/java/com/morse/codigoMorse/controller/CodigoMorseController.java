package com.morse.codigoMorse.controller;

import com.morse.codigoMorse.model.ConvertidorMorse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class CodigoMorseController {

    @GetMapping("/{cadena}")
    public String codigoMorse(@PathVariable String cadena){
        return ConvertidorMorse.obtenerTraduccion(cadena);
    }

}