package com.example.numer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class NumerosController {
        @GetMapping("/{palabra}")
        public String convertir(@PathVariable String palabra) {
            String morse[] = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", // a-i
                    ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", // j-q
                    ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", ".......", // r-" "
                    ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", // A-G
                    "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", // H-P
                    "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", // Q-X
                    "-.--", "--..", "......." }; // Y-Z

            String abecedario = (String) "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ ";
            int posicion = 0;
            String conversion = "";

            for (int f = 0; f < palabra.length(); f++) {
                posicion = abecedario.indexOf(palabra.charAt(f));
                conversion = conversion + morse[posicion] + " ";

            }
            return conversion;
        }
}
