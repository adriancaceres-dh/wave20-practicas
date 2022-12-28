package com.bootcamp.springintrop2roman.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.TreeMap;

@RestController
public class RomanController {
    @GetMapping("/{numero}")
    public String toRoman(@PathVariable int numero) {
        TreeMap<Integer, String> conversionMap = new TreeMap<>();
        conversionMap.put(1, "I");
        conversionMap.put(4, "IV");
        conversionMap.put(5, "V");
        conversionMap.put(9, "IX");
        conversionMap.put(10, "X");
        conversionMap.put(40, "XL");
        conversionMap.put(50, "L");
        conversionMap.put(90, "XC");
        conversionMap.put(100, "C");
        conversionMap.put(400, "CD");
        conversionMap.put(500, "D");
        conversionMap.put(900, "CM");
        conversionMap.put(1000, "M");

        StringBuilder sb = new StringBuilder();
        int n;
        while (numero != 0) {
            n = conversionMap.floorKey(numero);
            sb.append(conversionMap.get(n));
            numero -= n;
        }

        return sb.toString();
    }
}
