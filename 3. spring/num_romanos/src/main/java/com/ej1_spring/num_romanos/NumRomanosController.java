package com.ej1_spring.num_romanos;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.TreeMap;

import static java.util.Map.entry;

@RestController
public class NumRomanosController {

    @GetMapping("/enteroARomano/{numero}")
    public String enteroARomano(@PathVariable int numero) {
        String[] romanos = {"M","D","C","L","X","V","I"};
        int[] decimales = {1000,500,100,50,10,5,1};
        String res = "";
        int sum = 0;
        int indice = 0;
        while(sum != numero) {
            if(sum + decimales[indice] > numero){
                indice ++;
                continue;
            }
            sum += decimales[indice];
            res += romanos[indice];
        }
        return res;
    }


}
