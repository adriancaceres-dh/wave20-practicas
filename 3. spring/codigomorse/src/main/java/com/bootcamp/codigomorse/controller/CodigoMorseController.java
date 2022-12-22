package com.bootcamp.codigomorse.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class CodigoMorseController {
    Map<String, String> alfabetoCodigoMorse = new HashMap<>();

    @GetMapping("/{cadena}")
    public String codigoMorse(@PathVariable String cadena) {
        cargarAlfabetoCodigoMorse();
        return obtenerTraduccion(cadena);
    }

    public String obtenerTraduccion(String cadena) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] palabras = cadena.split("   ");
        for (String palabra : palabras) {
            String[] caracteres = palabra.split(" ");
            for (String caracter : caracteres) {
                stringBuilder.append(alfabetoCodigoMorse.get(caracter));
            }
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }
    public void cargarAlfabetoCodigoMorse() {
        alfabetoCodigoMorse.put(".-", "A");
        alfabetoCodigoMorse.put("-...", "B");
        alfabetoCodigoMorse.put("-.-.", "C");
        alfabetoCodigoMorse.put("-..", "D");
        alfabetoCodigoMorse.put(".", "E");
        alfabetoCodigoMorse.put("..-.", "F");
        alfabetoCodigoMorse.put("--.", "G");
        alfabetoCodigoMorse.put("....", "H");
        alfabetoCodigoMorse.put("..", "I");
        alfabetoCodigoMorse.put(".---", "J");
        alfabetoCodigoMorse.put("-.-", "K");
        alfabetoCodigoMorse.put(".-..", "L");
        alfabetoCodigoMorse.put("--", "M");
        alfabetoCodigoMorse.put("-.", "N");
        alfabetoCodigoMorse.put("---", "O");
        alfabetoCodigoMorse.put(".--.", "P");
        alfabetoCodigoMorse.put("--.-", "Q");
        alfabetoCodigoMorse.put(".-.", "R");
        alfabetoCodigoMorse.put("...", "S");
        alfabetoCodigoMorse.put("-", "T");
        alfabetoCodigoMorse.put("..-", "U");
        alfabetoCodigoMorse.put("...-", "V");
        alfabetoCodigoMorse.put(".--", "W");
        alfabetoCodigoMorse.put("-..-", "X");
        alfabetoCodigoMorse.put("-.--", "Y");
        alfabetoCodigoMorse.put("--..", "Z");
        alfabetoCodigoMorse.put(".----", "1");
        alfabetoCodigoMorse.put("..---", "2");
        alfabetoCodigoMorse.put("...--", "3");
        alfabetoCodigoMorse.put("....-", "4");
        alfabetoCodigoMorse.put(".....", "5");
        alfabetoCodigoMorse.put("-....", "6");
        alfabetoCodigoMorse.put("--...", "7");
        alfabetoCodigoMorse.put("---..", "8");
        alfabetoCodigoMorse.put("----.", "9");
        alfabetoCodigoMorse.put("-----", "0");
        alfabetoCodigoMorse.put("..--..", "?");
        alfabetoCodigoMorse.put("-.-.--", "!");
        alfabetoCodigoMorse.put(".-.-.-", ".");
        alfabetoCodigoMorse.put("--..--", ",");
    }
}