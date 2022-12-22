package com.bootcamp.springboot.numerosRomanos;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class numerosRomanos {

    @GetMapping("/")
    public String indicaciones() { return "Ingrese en la URI el número a romanizar"; }

    @GetMapping("/{num}")
    public String romanizar (@PathVariable int num) {
        return "El número " + num + " romanizado, es: " + intToRoman(num);
    }

    public static String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanLetters = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        String roman = "";
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                num -= values[i];
                roman += romanLetters[i];
            }
        }
        return roman;
    }
    }