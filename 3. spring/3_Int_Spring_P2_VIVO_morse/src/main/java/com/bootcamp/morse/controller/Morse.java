package com.bootcamp.morse.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.TreeMap;
import java.util.stream.Collectors;

@RestController
public class Morse {
    TreeMap<String,String> mapMorse;

    public Morse() {
        this.mapMorse = new TreeMap<>();

        mapMorse.put(".-", "A");
        mapMorse.put("-...", "B");
        mapMorse.put("-.-.", "C");
        mapMorse.put("-..", "D");
        mapMorse.put(".", "E");
        mapMorse.put("..-.", "F");
        mapMorse.put("--.", "G");
        mapMorse.put("....", "H");
        mapMorse.put("..", "I");
        mapMorse.put(".---", "J");
        mapMorse.put("-.-", "K");
        mapMorse.put(".-..", "L");
        mapMorse.put("--", "M");
        mapMorse.put("-.", "N");
        mapMorse.put("---", "O");
        mapMorse.put(".--.", "P");
        mapMorse.put("--.-", "Q");
        mapMorse.put(".-.", "R");
        mapMorse.put("...", "S");
        mapMorse.put("-", "T");
        mapMorse.put("..-", "U");
        mapMorse.put("...-", "V");
        mapMorse.put(".--", "W");
        mapMorse.put("-..-", "X");
        mapMorse.put("-.--", "Y");
        mapMorse.put("--..", "Z");
        mapMorse.put(".----", "1");
        mapMorse.put("..---", "2");
        mapMorse.put("...--", "3");
        mapMorse.put("....-", "4");
        mapMorse.put(".....", "5");
        mapMorse.put("-....", "6");
        mapMorse.put("--...", "7");
        mapMorse.put("---..", "8");
        mapMorse.put("----.", "9");
        mapMorse.put("-----", "0");
        mapMorse.put("..--..", "?");
        mapMorse.put(".-.-.-", ".");
        mapMorse.put("-.-.--", "!");
        mapMorse.put("--..--", ",");
        mapMorse.put("X", " ");

    }

    //Comentario
    @GetMapping("/morseToEsp/{morse}")
    public String morseToEsp(@PathVariable String morse){
        //apRomanos.entrySet().stream().forEach(i -> i == decimal);
        String espacios = morse.replaceAll("   "," X ");

        String[] palabras = espacios.split(" ");

        //For
        /*
        String espa = "";
        for(String palabra : palabras){
            espa = espa + mapMorse.get(palabra);
        }
        return espa;
        */

        //Stream
        return Arrays.stream(palabras).map(s -> mapMorse.get(s)).collect(Collectors.joining());
    }
}
