package com.bootcamp.codigoMorse.controlador;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class CodigoMorse {

    String morse[] = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", // A-G
            "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", // H-P
            "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", // Q-X
            "-.--", "--..", ".......",".-.-.-" }; // Y-Z

    String abecedario []= {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z", "   "," "};
    Map<String, String> map = new HashMap<>();
    ArrayList letra= new ArrayList<>();


    @GetMapping("/palabra/{value}")
    public String convertirAMorse(@PathVariable String value){
        for(int i=0; i< morse.length; i++){
            map.put(morse[i], abecedario[i]);
        }
        value = value.toUpperCase();
        String result = "";

        String palabras[] = value.split(" ");


        for (int i = 0; i < palabras.length; i++){
            for(int j=0; j<palabras[i].length();j++){
                letra.add( palabras[i].charAt(j));
            }
            letra.add(" ");
        }

        for (int i=0; i<letra.size();i++){
            String o = letra.get(i).toString();
          result +=  map.entrySet().stream().filter(x->x.getValue().equals(o)).findFirst().map(Map.Entry::getKey)
                  .orElse(null);
          result +=" ";

        }
        
        return result;
    }


    @GetMapping("/codigo/{value}")
    public String convertirAEspanol(@PathVariable String value){
        for(int i=0; i< morse.length; i++){
            map.put(morse[i], abecedario[i]);
        }
        String result = "";
        String codigoMorseVector[] = value.split("   ");

        for(int i=0; i<codigoMorseVector.length;i++){
            String subVector[] = codigoMorseVector[i].split(" ");

            for (int j=0; j<subVector.length;j++){
                String o = subVector[j].toString();
                result +=  map.entrySet().stream().filter(x->x.getKey().equals(o)).findFirst().map(Map.Entry::getValue)
                        .orElse(null);
            }
            result+=" ";
        }
        return result;
    }
}
