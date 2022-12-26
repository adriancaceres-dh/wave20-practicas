package com.bootcamp.codigomorse.model;

import java.util.HashMap;
import java.util.Map;

public class CodigoMorse {

        private Map<String,String> equivalencias;

        public CodigoMorse(){
            equivalencias = new HashMap<>();
            String letras [] = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
            String morseCode [] = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
            for(int i = 0; i < letras.length; i++)
            {
                this.equivalencias.put(morseCode[i],letras[i]);
            };
        }

        public String caracterToMorse (String letraMorse){
            return equivalencias.get(letraMorse);
        }

        public String retornarPalabra (String codigoMorse){
            StringBuilder sb = new StringBuilder();
            String [] letras = codigoMorse.split(" ");
            for (String l: letras) {
                String caracter = caracterToMorse(l);
                sb.append(caracter);
            }
            return sb.toString();
        }

        public String decodificar (String codigoMorse){
            StringBuilder sb = new StringBuilder();
            String [] palabras = codigoMorse.split("   ");
            for (String p: palabras){
                String palabraDecodificada = retornarPalabra(p);
                sb.append(palabraDecodificada);
                sb.append(" ");
            }
            return sb.toString();
        }
}
