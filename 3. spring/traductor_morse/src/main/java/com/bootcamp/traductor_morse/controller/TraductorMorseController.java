package com.bootcamp.traductor_morse.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TraductorMorseController {

    Map<String, String> diccionario = new HashMap<>(){
        {
            put(".-","A");
            put("-...","B");
            put("-.-.","C");
            put("-..","D");
            put(".","E");
            put("..-.","F");
            put("--.","G");
            put("....","H");
            put("..","I");
            put(".---","J");
            put("-.-","K");
            put(".-..","L");
            put("--","M");
            put("-.","N");
            put("---","O");
            put(".--.","P");
            put("--.-","Q");
            put(".-.","R");
            put("...","S");
            put("-","T");
            put("..-","U");
            put("...-","V");
            put(".--","W");
            put("-..-","X");
            put("-.--","Y");
            put("--..","Z");
            put("-----","0");
            put(".----","1");
            put("..---","2");
            put("...--","3");
            put("....-","4");
            put(".....","5");
            put("-....","6");
            put("--...","7");
            put("---..","8");
            put("----.","9");
            put(".-.-.-",".");
            put("--..--",",");
            put("..--..","?");
            put("−.−.−−","!");
            put("_"," "); //Si mandan un triple espacio lo voy a reemplazar por "_" (Durante la traduccion se va a traducir como un espacio)
        }
    };

        @GetMapping("/{codigo}")
        public String traducir(@PathVariable String codigo){
            codigo = codigo.replaceAll("   ", " _ ");
            String[] codigos = codigo.split(" ");
            String traduccion = "";
            for(int i = 0; i < codigos.length; i++){
                traduccion = traduccion + diccionario.get(codigos[i]);
            }
            return traduccion;
        }
    }


