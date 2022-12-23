package com.bootcamp.morse.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.TreeMap;
import java.util.stream.Collectors;

@RestController
public class Morse {
    TreeMap<String,String> mapMorseCode;

    public Morse() {
        this.mapMorseCode = new TreeMap<>();

        mapMorseCode.put(".-", "A");
        mapMorseCode.put("-...", "B");
        mapMorseCode.put("-.-.", "C");
        mapMorseCode.put("-..", "D");
        mapMorseCode.put(".", "E");
        mapMorseCode.put("..-.", "F");
        mapMorseCode.put("--.", "G");
        mapMorseCode.put("....", "H");
        mapMorseCode.put("..", "I");
        mapMorseCode.put(".---", "J");
        mapMorseCode.put("-.-", "K");
        mapMorseCode.put(".-..", "L");
        mapMorseCode.put("--", "M");
        mapMorseCode.put("-.", "N");
        mapMorseCode.put("---", "O");
        mapMorseCode.put(".--.", "P");
        mapMorseCode.put("--.-", "Q");
        mapMorseCode.put(".-.", "R");
        mapMorseCode.put("...", "S");
        mapMorseCode.put("-", "T");
        mapMorseCode.put("..-", "U");
        mapMorseCode.put("...-", "V");
        mapMorseCode.put(".--", "W");
        mapMorseCode.put("-..-", "X");
        mapMorseCode.put("-.--", "Y");
        mapMorseCode.put("--..", "Z");
        mapMorseCode.put(".----", "1");
        mapMorseCode.put("..---", "2");
        mapMorseCode.put("...--", "3");
        mapMorseCode.put("....-", "4");
        mapMorseCode.put(".....", "5");
        mapMorseCode.put("-....", "6");
        mapMorseCode.put("--...", "7");
        mapMorseCode.put("---..", "8");
        mapMorseCode.put("----.", "9");
        mapMorseCode.put("-----", "0");
        mapMorseCode.put("..--..", "?");
        mapMorseCode.put(".-.-.-", ".");
        mapMorseCode.put("-.-.--", "!");
        mapMorseCode.put("--..--", ",");
        mapMorseCode.put("X", " ");

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
            espa = espa + mapMorseCode.get(palabra);
        }
        return espa;
        */

        //Stream
        return Arrays.stream(palabras)
                .map(s -> mapMorseCode.get(s))
                .collect(Collectors.joining());
    }
}
