package com.bootcamp.codigomorse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CodigoMorseController {

    @GetMapping()
    public String bienvenida() {
        return "Hola, bienvenido al decodificador de codigo morse, introduce el codigo a decodificar con el " +
                "siguiente formato" +
                "\n1. Para delimitar caracteres utiliza una barra |" +
                "\n2. Para simular espacios entre palabras utilizada dos barras ||";
    }

    @GetMapping("/{morse}")
    public String resultado(@PathVariable String morse) {
        return "Decodificación exitosa!\nSu texto es: " + traductorMorse(morse);
    }

    public String traductorMorse(String morse) {
        String traduccion = "";
        String[] palabras = morse.split("  ");

        for (int i = 0; i<palabras.length;i++) {
            String[] caracteres = palabras[i].split(" ");
            for (int j = 0; j<caracteres.length; j++) {
                traduccion += traducir(caracteres[j]);
            }
            traduccion += " ";
        }
        return traduccion.trim();
    }

    private String traducir(String letra) {
        String caracterResultante = "";
        switch (letra) {
            case ".-.-.-":
                caracterResultante = ".";
                break;
            case "-.-.--":
                caracterResultante = "!";
                break;
            case "···−−−···":
                caracterResultante = "SOS";
                break;
            case ".-":
                caracterResultante = "A";
                break;
            case "-...":
                caracterResultante = "B";
                break;
            case "-.-.":
                caracterResultante = "C";
                break;
            case "-..":
                caracterResultante = "D";
                break;
            case ".":
                caracterResultante = "E";
                break;
            case "..-.":
                caracterResultante = "F";
                break;
            case "--.":
                caracterResultante = "G";
                break;
            case "....":
                caracterResultante = "H";
                break;
            case "..":
                caracterResultante = "I";
                break;
            case ".---":
                caracterResultante = "J";
                break;
            case "-.-":
                caracterResultante = "K";
                break;
            case ".-..":
                caracterResultante = "L";
                break;
            case "--":
                caracterResultante = "M";
                break;
            case "-.":
                caracterResultante = "N";
                break;
            case "---":
                caracterResultante = "O";
                break;
            case ".--.":
                caracterResultante = "P";
                break;
            case "--.-":
                caracterResultante = "Q";
                break;
            case ".-.":
                caracterResultante = "R";
                break;
            case "...":
                caracterResultante = "S";
                break;
            case "-":
                caracterResultante = "T";
                break;
            case "..-":
                caracterResultante = "U";
                break;
            case "...-":
                caracterResultante = "V";
                break;
            case ".--":
                caracterResultante = "W";
                break;
            case "-..-":
                caracterResultante = "X";
                break;
            case "-.--":
                caracterResultante = "Y";
                break;
            case "--..":
                caracterResultante = "Z";
                break;
            case ".----":
                caracterResultante = "1";
                break;
            case "..---":
                caracterResultante = "2";
                break;
            case "...--":
                caracterResultante = "3";
                break;
            case "....-":
                caracterResultante = "4";
                break;
            case ".....":
                caracterResultante = "5";
                break;
            case "_....":
                caracterResultante = "6";
                break;
            case "__...":
                caracterResultante = "7";
                break;
            case "___..":
                caracterResultante = "8";
                break;
            case "____.":
                caracterResultante = "9";
                break;
            case "_____":
                caracterResultante = "0";
                break;
            default:
                break;
        }
        return caracterResultante;
    }

}
