package com.bootcamp.sistema_maven.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class MorseCode {
    @GetMapping("/romanos/morse/{morse}")
    public String ConvertMorse(@PathVariable String morse) {
        String mensaje = null;
        String[] words = morse.split("   ");
        if (words.length == 0) {
            return "";
        }
        StringBuilder stringBuffer = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.isEmpty())
                continue;
            String[] characters = word.split(" ");
            for (String character : characters) {
                stringBuffer.append(decodeLetter(character));
            }
            if (i != words.length - 1)
                stringBuffer.append(" ");
        }

        return stringBuffer.toString();
    }
    private static String decodeLetter(String letter){
        String result="";

        Map<String, String> convMorse = new HashMap<>();
        convMorse.put(".-", "A");
        convMorse.put("-..", "B");
        convMorse.put("-.-.", "C");
        convMorse.put("-..", "D");
        convMorse.put(".", "E");
        convMorse.put("..-.", "F");
        convMorse.put("--.", "G");
        convMorse.put("....", "H");
        convMorse.put("..", "I");
        convMorse.put(".---", "J");
        convMorse.put("-.-", "K");
        convMorse.put(".-..", "L");
        convMorse.put("--", "M");
        convMorse.put("-.", "N");
        convMorse.put("---", "O");
        convMorse.put(".--.", "P");
        convMorse.put("--.-", "Q");
        convMorse.put(".-.", "R");
        convMorse.put("...", "S");
        convMorse.put("-", "T");
        convMorse.put("..-", "U");
        convMorse.put("...-", "V");
        convMorse.put(".--", "W");
        convMorse.put("-..-", "X");
        convMorse.put("-.--", "Y");
        convMorse.put("--..", "Z");

        for ( String i: convMorse.keySet() ){

            if (i.equals(letter)){
                result = convMorse.get(i);

            }

        }
        return result;

    }



}
