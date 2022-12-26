package com.bootcamp.morse.services;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
public class CodigoService {

    public String getCodigo(String word){

        Map<String,String> codes = new HashMap<>();

        codes.put(".-.-.-", ".");
        codes.put("-.-.--", "!");
        codes.put("···−−−···", "SOS");
        codes.put(".-", "A");
        codes.put("-...", "B");
        codes.put("-.-.", "C");
        codes.put("-..", "D");
        codes.put( ".", "E");
        codes.put("..-.", "F");
        codes.put("--.", "G");
        codes.put("....", "H");
        codes.put("..", "I");
        codes.put(".---", "J");
        codes.put("-.-", "K");
        codes.put(".-..", "L");
        codes.put("--", "M");
        codes.put("-.", "N");
        codes.put("---", "O");
        codes.put(".--.","P");
        codes.put("--.-", "Q");
        codes.put("...","S");
        codes.put("-","T");
        codes.put("..-", "U");
        codes.put("...-", "V");
        codes.put( ".--", "W");
        codes.put("-..-", "X");
        codes.put("-.--", "Y");
        codes.put("--..", "Z");
        codes.put(".----", "1");
        codes.put("..---","2");
        codes.put("...--", "3");
        codes.put( "....-", "4" );
        codes.put(".....", "5" );
        codes.put("_....", "6" );
        codes.put("__...", "7" );
        codes.put("___..", "8" );
        codes.put("____.", "9" );
        codes.put("_____", "0" );

        return codes.get(word);


    }

}
