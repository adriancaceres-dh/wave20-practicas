package com.bootcamp.texo_a_codigomorse.utils;

import java.util.Hashtable;
import java.util.Set;

public class TraductorAscciMorse {



    public static Hashtable<String, String> obtenerEquivalencias() {
        Hashtable<String, String> equivalencias = new Hashtable<>();
        equivalencias.put(".-","A");
        equivalencias.put("-...","B");
        equivalencias.put("-.-.","C");
        equivalencias.put("----","CH");
        equivalencias.put("-..","D");
        equivalencias.put(".","E");
        equivalencias.put("..-.","F");
        equivalencias.put("--.","G");
        equivalencias.put("....","H");
        equivalencias.put("..","I");
        equivalencias.put(".---","J");
        equivalencias.put("-.-","K");
        equivalencias.put(".-..","L");
        equivalencias.put("--","M");
        equivalencias.put("-.","N");
        equivalencias.put("--.--","Ñ");
        equivalencias.put("---","O");
        equivalencias.put(".--.","P");
        equivalencias.put("--.-","Q");
        equivalencias.put(".-.","R");
        equivalencias.put("...","S");
        equivalencias.put("-","T");
        equivalencias.put("..-","U");
        equivalencias.put("...-","V");
        equivalencias.put(".--","W");
        equivalencias.put("-..-","X");
        equivalencias.put("-.--","Y");
        equivalencias.put("--..","Z");
        equivalencias.put("-----","0");
        equivalencias.put(".----","1");
        equivalencias.put("..---","2");
        equivalencias.put("...--","3");
        equivalencias.put("....-","4");
        equivalencias.put(".....","5");
        equivalencias.put("-....","6");
        equivalencias.put("--...","7");
        equivalencias.put("---..","8");
        equivalencias.put("----.","9");
        equivalencias.put(".-.-.-",".");
        equivalencias.put("--..--",",");
        equivalencias.put("---...",":");
        equivalencias.put("..--..","?");
        equivalencias.put(".----.","'");
        equivalencias.put("-....-","-");
        equivalencias.put("-..-.","/");
        equivalencias.put( ".-..-.","\"");
        equivalencias.put(".--.-.","@");
        equivalencias.put("-...-","=");
        equivalencias.put("−.−.−−","!");
        return equivalencias;
    }

    public static String morseToAscci(String codigoMorse){
        String[] morseCharacters = codigoMorse.split(" ");
        String result = "";

        for (int i = 0; i < morseCharacters.length; i++){
            result = result + obtenerEquivalencias().get(morseCharacters[i]);

        }
        return result;
    }

    
}
