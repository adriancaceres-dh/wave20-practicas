package com.example.codigomorse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CodificadorMorse {

    @GetMapping("/{texto}")
    public String morseACastellano(@PathVariable String texto) {
        return convertir(texto);
    }

    public static String convertir(String texto) {
        String traduccion = "";
        String[] palabras = texto.split("   ");
        for (String p : palabras) {
            String[] caracteres = p.split(" ");
            for (String c : caracteres) {
                traduccion += CodigoMorseApplication.diccionario.get(c);
            }
            traduccion += " ";
        }
        return traduccion;
    }
}
