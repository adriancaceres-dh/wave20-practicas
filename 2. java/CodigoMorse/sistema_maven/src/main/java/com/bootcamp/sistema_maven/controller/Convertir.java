package com.bootcamp.sistema_maven.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Convertir {
    String romano;
    @GetMapping("/romanos/{numero}")
    public String numeroARomano(@PathVariable int numero){
        if (numero==1){
             romano="I";
        }

        if (numero==2){
            romano="II";
        }
        if (numero==3){
            romano="III";
        }
        if (numero==4){
            romano="IV";
        }
        if (numero==5){
            romano="VI";
        }
        if (numero==7){
            romano="VII";
        }
        if (numero==10){
            romano="X";
        }
        if (numero==13){
            romano="XIII";
        }


        return romano;
    }
}
