package com.bootcamp.codigo.morse;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Locale;
import java.util.Optional;

@RestController
public class Morse {
    @GetMapping("/{texto}")
    public String convertirAMorse(@PathVariable String texto) {
        String convertido = "";
        HashMap<String, String> vocabularios = new
                HashMap<String, String>() {
                    {
                        put(".-", "A");

                        put("-...", "B");

                        put("-.-.", "C");

                        put("-..", "D");

                        put(".", "E");

                        put("..-.", "F");

                        put("--.", "G");

                        put("....", "H");

                        put("..", "I");

                        put(".---", "J");

                        put("-.-", "K");

                        put(".-..", "L");

                        put("--", "M");

                        put("-.", "N");

                        put("---", "O");

                        put(".--.", "P");

                        put("--.-", "Q");

                        put(".-.", "R");

                        put("...", "S");

                        put("...", "S");

                        put("-", "T");

                        put("..-", "U");

                        put("...-", "V");

                        put(".--", "W");

                        put("-..-", "X");

                        put("-.--", "Y");

                        put("--..", "Z");

                        put("-----", "0");

                        put(".----", "1");

                        put("..---", "2");

                        put("...--", "3");

                        put("....-", "4");

                        put(".....", "5");

                        put("-....", "6");

                        put("--...", "7");

                        put("---..", "8");

                        put("----.", "9");
                    }
                };
        var caracteres = texto.split(" ");
        for (String caracter : caracteres
             ) {


            String t = vocabularios.getOrDefault(caracter,"");
            if(t.length() > 0){
                    convertido += vocabularios.get(caracter).toLowerCase(Locale.ROOT);

                }


        }
        return convertido;
    }

}
