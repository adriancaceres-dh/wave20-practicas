package com.example.codigomorse.controller;

import com.example.codigomorse.entity.ClavesMorse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MorseController {

    @GetMapping("/traducirMorse/{morse}")
    public String traducirMorse(@PathVariable String morse){
        ClavesMorse clavesMorse = new ClavesMorse();
        return clavesMorse.traducir(morse);
    }
}
