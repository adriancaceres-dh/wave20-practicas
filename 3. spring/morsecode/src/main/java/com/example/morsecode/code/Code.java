package com.example.morsecode.code;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class Code {
    public static final Map<String, String> code = new HashMap<String, String>();

    static {
        code.put(".-.-.-", ".");
        code.put("--..--", ",");
        code.put("..--..", "?");
        code.put("-.-.--", "!");
        code.put(".-", "A");
        code.put("-...", "B");
        code.put("-.-.", "C");
        code.put("-..", "D");
        code.put(".", "E");
        code.put("..-.", "F");
        code.put("--.", "G");
        code.put("....", "H");
        code.put("..", "I");
        code.put(".---", "J");
        code.put("-.-", "K");
        code.put(".-..", "L");
        code.put("--", "M");
        code.put("-.", "N");
        code.put("---", "O");
        code.put(".--.", "P");
        code.put("--.-", "Q");
        code.put(".-.", "R");
        code.put("...", "S");
        code.put("-", "T");
        code.put("..-", "U");
        code.put("...-", "V");
        code.put(".--", "W");
        code.put("-..-", "X");
        code.put("-.--", "Y");
        code.put("--..", "Z");
        code.put("-----", "0");
        code.put(".----", "1");
        code.put("..---", "2");
        code.put("...--", "3");
        code.put("....-", "4");
        code.put(".....", "5");
        code.put("-....", "6");
        code.put("--...", "7");
        code.put("---..", "8");
        code.put("----.", "9");
    }

    @GetMapping("/{codigomorse}")
    public String getCode(@PathVariable String codigomorse){
        StringBuilder letra = new StringBuilder();
        StringBuilder frase = new StringBuilder();

        for(int i=0; i<codigomorse.length(); i++){
            if(codigomorse.charAt(i) != ' ') letra.append(codigomorse.charAt(i));
            else {
                if(codigomorse.charAt(i-1) == ' ' && codigomorse.charAt(i+1) == ' '){
                    frase.append(' ');
                    continue;
                }
                if(codigomorse.charAt(i-1) != ' '){
                    frase.append(code.get(letra.toString()));
                    letra = new StringBuilder();
                }
            }
        }

        frase.append(code.get(letra.toString()));

        return frase.toString();
    }
}
