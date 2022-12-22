package com.example.codigomorse.entity;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ClavesMorse {

    Map<String, String> claves;

    public ClavesMorse() {
        claves = new HashMap<>();
        claves.put(".-", "A");
        claves.put("-...", "B");
        claves.put("-.-.", "C");
        claves.put("-..", "D");
        claves.put(".", "E");
        claves.put("..-.", "F");
        claves.put("--.", "G");
        claves.put("....", "H");
        claves.put("..", "I");
        claves.put(".---", "J");
        claves.put("-.-", "K");
        claves.put(".-..", "L");
        claves.put("--", "M");
        claves.put("-.", "N");
        claves.put("---", "O");
        claves.put(".--.", "P");
        claves.put("--.-", "Q");
        claves.put(".-.", "R");
        claves.put("...", "S");
        claves.put("-", "T");
        claves.put("..-", "U");
        claves.put("...-", "V");
        claves.put(".--", "W");
        claves.put("-..-", "X");
        claves.put("-.--", "Y");
        claves.put("--..", "Z");
        claves.put(".----", "1");
        claves.put("..---", "2");
        claves.put("...--", "3");
        claves.put("....-", "4");
        claves.put(".....", "5");
        claves.put("-....", "6");
        claves.put("--...", "7");
        claves.put("---..", "8");
        claves.put("----.", "9");
        claves.put("-----", "0");
        claves.put("..--..", "?");
        claves.put(".-.-.-", ".");
        claves.put("-.-.--", "!");
        claves.put("--..--", ",");
        claves.put("_", " ");
    }

    public String devolverCaracter(String morse) {
        return claves.get(morse);
    }

    public String traducir(String morse) {
        String traducido = "";
        morse = morse.replaceAll("   ", " _ ");
        String[] palabras = morse.split(" ");
        if (palabras.length > 0) {
            traducido = Arrays.stream(palabras).map(p -> devolverCaracter(p)).collect(Collectors.joining());
        }
        return traducido;
    }

}
