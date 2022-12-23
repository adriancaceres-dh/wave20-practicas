package com.bootcamp.texo_a_codigomorse.controllers;

import com.bootcamp.texo_a_codigomorse.utils.TraductorAscciMorse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Hashtable;
import java.util.Set;

@RestController
public class IndexController {



    @GetMapping("/{codigo}")
    public String decodificar(@PathVariable String codigo){

        //return codigo;
        return TraductorAscciMorse.morseToAscci(codigo);
    }


}



