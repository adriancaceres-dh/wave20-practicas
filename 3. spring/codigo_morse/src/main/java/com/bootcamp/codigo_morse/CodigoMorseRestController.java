package com.bootcamp.codigo_morse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CodigoMorseRestController {
    
    @GetMapping("/{frase}")
    
    public String separarLetras (@PathVariable String frase) {

        String[] palabras = frase.split("   "); // separo el input en palabras
        String resultado="";

        for (int i=0; i < palabras.length; i++) { // recorro todas las palabras
            String palabra = palabras[i];
            String[] letras= palabra.split(" "); // separo la palabra en un arreglo de letras
            for(int j=0; j<letras.length; j++){ // voy llamando a reconocerLetra para cada indice del arreglo letras
                resultado+= reconocerLetra(letras[j]);
            }
            if (palabras.length>i) {
                resultado+=" "; // Luego de decodificar la palabra si el arreglo de palabras contiene otras entonces agregamos un espacio y vamos a la siguiente
            }
        }
        return resultado.toUpperCase();
    }

    
    private static String reconocerLetra(String letraEnMorse) {
        String letra = "";
        switch (letraEnMorse) {
            case ".-.-.-":
                letra = ".";
                break;
            case "-.-.--":
                letra = "!";
                break;
            case "···−−−···":
                letra = "SOS";
                break;
            case ".-":
                letra = "A";
                break;
            case "-...":
                letra = "B";
                break;
            case "-.-.":
                letra = "C";
                break;
            case "-..":
                letra = "D";
                break;
            case ".":
                letra = "E";
                break;
            case "..-.":
                letra = "F";
                break;
            case "--.":
                letra = "G";
                break;
            case "....":
                letra = "H";
                break;
            case "..":
                letra = "I";
                break;
            case ".---":
                letra = "J";
                break;
            case "-.-":
                letra = "K";
                break;
            case ".-..":
                letra = "L";
                break;
            case "--":
                letra = "M";
                break;
            case "-.":
                letra = "N";
                break;
            case "---":
                letra = "O";
                break;
            case ".--.":
                letra = "P";
                break;
            case "--.-":
                letra = "Q";
                break;
            case ".-.":
                letra = "R";
                break;
            case "...":
                letra = "S";
                break;
            case "-":
                letra = "T";
                break;
            case "..-":
                letra = "U";
                break;
            case "...-":
                letra = "V";
                break;
            case ".--":
                letra = "W";
                break;
            case "-..-":
                letra = "X";
                break;
            case "-.--":
                letra = "Y";
                break;
            case "--..":
                letra = "Z";
                break;
            case ".----":
                letra = "1";
                break;
            case "..---":
                letra = "2";
                break;
            case "...--":
                letra = "3";
                break;
            case "....-":
                letra = "4";
                break;
            case ".....":
                letra = "5";
                break;
            case "_....":
                letra = "6";
                break;
            case "__...":
                letra = "7";
                break;
            case "___..":
                letra = "8";
                break;
            case "____.":
                letra = "9";
                break;
            case "_____":
                letra = "0";
                break;
            default:
                break;
        }
        return letra;
    }
    
    
    
    
    
    
}
