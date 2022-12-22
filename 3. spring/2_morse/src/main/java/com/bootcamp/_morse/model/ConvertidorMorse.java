package com.bootcamp._morse.model;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class ConvertidorMorse {

    //Juan Camilo Arango Valle, Franco Andres Alvarez Alvarado, Edison Alejandro Torres Munoz

    private final static Map<String, String> mapaMorse = new HashMap<>(){{
        put(".-.-.-",".");
        put(".-","a");
        put("-...","b");
        put("-.-.","c");
        put("-..","d");
        put(".","e");
        put("..-.","f");
        put("--.","g");
        put("....","h");
        put("..","i");
        put(".---","j");
        put("-.-","k");
        put(".-..","l");
        put("--","m");
        put("-.","n");
        put("---","o");
        put(".--.","p");
        put("--.-","q");
        put(".-.","r");
        put("...","s");
        put("-","t");
        put("..-","u");
        put("...-","v");
        put(".--","w");
        put("-..-","x");
        put("-.--","y");
        put("--..","z");
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
        put("..--..","?");
        put("-.-.--","!");
        put("--..--",",");
    }};

    public static String convertir(String codigo){
        StringBuilder texto = new StringBuilder();
        String[] palabras = codigo.split("   ");
        for (String pal : palabras){
            String [] letras = pal.split(" ");
            for (String letra : letras){
                texto.append(mapaMorse.get(letra));
            }
            texto.append(" ");
        }
        return texto.toString().toUpperCase().trim();
    }
}
