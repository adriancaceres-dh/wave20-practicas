package com.bootcamp.numerosromanos.controller;

import com.bootcamp.numerosromanos.model.Conversor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
public class ConversorService {

    Conversor conversor;

    @GetMapping()
    public String saludar(){
        return "Hello World";
    }

    @GetMapping("/convertir/{numero}")
    public String convertirNumero(@PathVariable("numero") Integer numero){
        return Conversor.convertirNumero(numero);
    }

}
