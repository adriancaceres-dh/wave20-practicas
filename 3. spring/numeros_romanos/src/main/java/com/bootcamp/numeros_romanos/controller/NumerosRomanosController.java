package com.bootcamp.numeros_romanos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class NumerosRomanosController {

    // Mapa con edge cases (combinaciones)
    private static final Map<Integer, String> simbolosExtra = new TreeMap<>(Collections.reverseOrder()) {{
        put(1, "I");
        put(4, "IV");
        put(5, "V");
        put(9, "IX");
        put(10, "X");
        put(40, "XL");
        put(50, "L");
        put(90, "XC");
        put(100, "C");
        put(400, "CD");
        put(500, "D");
        put(900, "CM");
        put(1000, "M");
    }};

    // Mapa sin edge cases
    private static final Map<Integer, String> simbolosBase = new TreeMap<>(Collections.reverseOrder()) {{
        put(1, "I");
        put(5, "V");
        put(10, "X");
        put(50, "L");
        put(100, "C");
        put(500, "D");
        put(1000, "M");
    }};

    @GetMapping("/")
    public String index() {
        return "Números Romanos Controller";
    }

    @GetMapping("/convertir/edge-cases/{numero}")
    public String convertirEdgeCases(@PathVariable int numero) {
        return calcularRomanoEdgeCases(numero);
    }

    @GetMapping("/convertir/bases/{numero}")
    public String convertirBases(@PathVariable int numero) {
        return calcularRomanoBases(numero);
    }

    private String calcularRomanoEdgeCases(int numero) {
        StringBuilder romano = new StringBuilder();

        for(Map.Entry<Integer, String> simbolo : simbolosExtra.entrySet()) {
            if(numero >= simbolo.getKey()) {
                romano.append(simbolo.getValue().repeat(numero / simbolo.getKey()));
                numero = numero % simbolo.getKey();
            }
        }

        return romano.toString();
    }

    private String calcularRomanoBases(int numero) {
        StringBuilder romano = new StringBuilder();

        for(Map.Entry<Integer, String> simbolo : simbolosBase.entrySet()) {
            if(numero >= simbolo.getKey()) {
                romano.append(simbolo.getValue().repeat(numero / simbolo.getKey()));
                numero = numero % simbolo.getKey();
            }

            boolean esExponenteDiez = Math.log10(simbolo.getKey()) % 1 == 0;
            int extra = esExponenteDiez ? simbolo.getKey() - (simbolo.getKey() / 10) : simbolo.getKey() - (simbolo.getKey() / 5);

            if(numero >= extra) {
                int extraKey = esExponenteDiez ? simbolo.getKey() / 10 : simbolo.getKey() / 5;
                romano.append(simbolosBase.get(extraKey)).append(simbolo.getValue());
                numero = numero % extra;
            }
        }

        return romano.toString();
    }
}
