package com.bootcamp._morse.controller;


import com.bootcamp._morse.model.ConvertidorMorse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class MorseController {


    @GetMapping("/{codigo}")
    public String conversorMorse(@PathVariable String codigo){
            return ConvertidorMorse.convertir(codigo);
    }

}
