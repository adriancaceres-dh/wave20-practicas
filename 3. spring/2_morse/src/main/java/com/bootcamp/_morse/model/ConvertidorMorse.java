package com.bootcamp._morse.model;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class ConvertidorMorse {

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

    /* Solucion con:
            -Juan Camilo Arango Valle
            -Franco Andres Alvarez Alvarado
            -Edison Alejandro Torres Munoz

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
    */

    public static String convertir(String codigo){
        try {
            String texto = "";
            String letraMorse = "";
            int len= codigo.length();
            for (int i = 0; i < len; i++) {
                if (codigo.charAt(i) == '.' || codigo.charAt(i) == '-') {
                    letraMorse += codigo.charAt(i);                                                   //Agrega '.' o '-' al codigo de la letra.
                    if(i+1==len && mapaMorse.get(letraMorse)!=null) texto+=mapaMorse.get(letraMorse); //Si llega al final agrega la letra.
                } else if (i+2<len && codigo.charAt(i + 1) == ' ' && codigo.charAt(i + 2) == ' ') {   //Si el espacio actual y los dos siguientes son espacio,
                    if(mapaMorse.get(letraMorse)!=null) texto += mapaMorse.get(letraMorse);
                    texto+=" ";                                                                       //agrego la letra mas el espacio.
                    letraMorse = "";
                    i+= 2;                                                                            //Salteo los espacios.
                } else {
                    if(mapaMorse.get(letraMorse)!=null) texto += mapaMorse.get(letraMorse);           //La alternativa es un solo espacio o caracter invalido, agrego la letra y voy al siguiente.
                    letraMorse="";
                }
            }
            return texto.toUpperCase();
        } catch (Exception e){
            return "No se pudo convertir";
        }
    }

}
