package com.bootcamp.codigo_morse.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CodigoMorseController {
    private static final Map<String, String> codigos = new HashMap<>(){{
        put(".-", "a");
        put("-...", "b");
        put("-.-.", "c");
        put("-..", "d");
        put(".", "e");
        put("..-.", "f");
        put("--.", "g");
        put("....", "h");
        put("..", "i");
        put(".---", "j");
        put("-.-", "k");
        put(".-..", "l");
        put("--", "m");
        put("-.", "n");
        put("---", "o");
        put(".--.", "p");
        put("--.-", "q");
        put(".-.", "r");
        put("...", "s");
        put("-", "t");
        put("..-", "u");
        put("...-", "v");
        put(".--", "w");
        put("-..-", "x");
        put("-.--", "y");
        put("--..", "z");
        put(".----","1");
        put("..---","2");
        put("...--","3");
        put("....-","4");
        put(".....","5");
        put("-....","6");
        put("--...","7");
        put("---..","8");
        put("----.","9");
        put("-----","0");
        put(".-.-.-",".");
        put("—..--", ",");
        put("—...", ":");
        put("..—..", "?");
        put(".----.","'");
        put("-....-","-");
        put("-..-.", "/");
        put(".-..-.","\\");
        put(".—.-.","@");
        put("-...-", "=");
        put("−.−.−−", "!");
    }};

    @GetMapping("/{mensaje}")
    String decodificar(@PathVariable String mensaje) {
        StringBuilder decodificado = new StringBuilder();
        //-- . .-. -.-. .- -.. ---   .-.. .. -... .-. .
        String[] palabras = mensaje.split("   ");

        for(String p : palabras) {
            String[] letras = p.split(" ");
            Arrays.stream(letras).forEach(l -> decodificado.append(codigos.get(l)));
            decodificado.append(" ");
        }

        return decodificado.deleteCharAt(decodificado.length()-1).toString().toUpperCase();
    }
}