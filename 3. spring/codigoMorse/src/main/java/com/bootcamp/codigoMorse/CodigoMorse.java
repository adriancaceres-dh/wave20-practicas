package com.bootcamp.codigoMorse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import static com.bootcamp.codigoMorse.CodigoMorse3Application.diccionario;

@RestController
public class CodigoMorse {

    @GetMapping("/{texto}")
    public String morseACastellano (@PathVariable String texto) {
        return convertir (texto);
    }

    public static String convertir (String texto) {
        String traduccion = "";
        String[] palabras = texto.split("   ");
        for (String p : palabras){
            String[] caracteres = p.split(" ");
            for (String c : caracteres) {
                traduccion += diccionario.get(c);
            }
            traduccion += " ";
        }
        return traduccion;
    }

}
