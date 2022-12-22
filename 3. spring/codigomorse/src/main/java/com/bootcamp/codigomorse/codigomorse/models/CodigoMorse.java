package com.bootcamp.codigomorse.codigomorse.models;

import java.util.HashMap;
import java.util.Map;

public class CodigoMorse {
    private final static Map<String,Character> mapMorse = new HashMap<>(){
        {
            put( ".-",'a');
            put( "-...",'b');
            put(  "-.-.",'c');
            put(  "-..",'d');
            put(    ".",'e');
            put( "..-.",'f');
            put(  "--.",'g');
            put( "....",'h');
            put(   "..",'i');
            put( ".---",'j');
            put(   "-.-",'k');
            put( ".-..",'l');
            put(   "--",'m');
            put(   "-.",'n');
            put(  "---",'o');
            put( ".--.",'p');
            put( "--.-",'q');
            put( ".-.",'r');
            put(  "...",'s');
            put(   "-",'t');
            put(  "..-",'u');
            put( "...-",'v');
            put(  ".--",'w');
            put( "-..-",'x');
            put( "-.--",'y');
            put( "--..",'z');
            put( ".----",'1');
            put("..---",'2');
            put( "...--",'3');
            put( "....-",'4');
            put( ".....",'5');
            put( "-....",'6');
            put( "--...",'7');
            put( "---..",'8');
            put( "----.",'9');
            put( "-----",'0');
            put("..--..",'?');
            put("-.-.--",'!');
            put("--..--",',');
            put(".-.-.-",'.');

        }
    };

    public  static String convertirMorse(String codigo){
        StringBuilder sb = new StringBuilder();
        String[] palabras = codigo.split("   ");

        for (String palabra:palabras) {
            String [] letraMorse = palabra.split(" ");
            algo:
            for (String letra : letraMorse){

                sb.append(mapMorse.get(letra));
            }
            sb.append(" ");
        }
        return sb.toString().toUpperCase().trim();

    }

}
