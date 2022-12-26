package com.bootcamp.CodigoMorse.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class CodigoMorseController {

    @GetMapping("/{palabra}")
    public String conversion(@PathVariable String palabra){

        String[] caracteresMorse = palabra.split(" ");

        StringBuilder resultado = new StringBuilder();

        HashMap<String, Character> morse = new HashMap<>();
        morse.put(".-", 'a');
        morse.put("-...", 'b');
        morse.put("-.-.", 'c');
        morse.put("-..", 'd');
        morse.put(".", 'e');
        morse.put("..-.", 'f');
        morse.put("--.", 'g');
        morse.put("....", 'h');
        morse.put("..", 'i');
        morse.put(".---", 'j');
        morse.put("-.-", 'k');
        morse.put(".-..", 'l');
        morse.put("--", 'm');
        morse.put("-.", 'n');
        morse.put("---", 'o');
        morse.put(".--.", 'p');
        morse.put("--.-", 'q');
        morse.put(".-.", 'r');
        morse.put("...", 's');
        morse.put("-", 't');
        morse.put("..-", 'u');
        morse.put("...-", 'v');
        morse.put(".--", 'w');
        morse.put("-..-", 'x');
        morse.put("-.--", 'y');
        morse.put("--..", 'z');
        morse.put("-----",'0');
        morse.put(".----",'1');
        morse.put("..---",'2');
        morse.put("...--",'3');
        morse.put("....-",'4');
        morse.put(".....",'5');
        morse.put("-....",'6');
        morse.put("--...",'7');
        morse.put("---..",'8');
        morse.put("----.",'9');
        morse.put("",' ');

        try {
            for (String caracter : caracteresMorse) {
                char c = morse.get(caracter);
                resultado.append(c);
            }
        }catch (Exception e){
            return e.getMessage();
        }

        return resultado.toString().replace("  "," ").toUpperCase();
    }

}
