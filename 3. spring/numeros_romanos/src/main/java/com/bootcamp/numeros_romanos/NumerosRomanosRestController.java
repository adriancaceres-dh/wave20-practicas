package com.bootcamp.numeros_romanos;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import static java.lang.Integer.valueOf;

@RestController
public class NumerosRomanosRestController {

    @GetMapping("/{numero_recibido}")
    public String convertir (@PathVariable int numero_recibido) {
        String retorno = "El número " + numero_recibido + " equivale a ";
        boolean convertir = true;
        int numero = numero_recibido;

        if (numero_recibido==0){
            convertir= false;
            retorno = "Solo se pueden convertir números entre 1 y 2000.";

        }

        if (numero < 2000 && numero>=0) {
            while (convertir) {
                if (numero == 0) {
                    convertir = false;
                } else if (numero >= 1000) {
                    numero -= 1000;
                    retorno=retorno + "M";
                } else if (numero >= 900 && numero < 1000) {
                    numero -= 900;
                    retorno=retorno + "CM";
                } else if (numero >= 500 && numero < 900) {
                    numero -= 500;
                    retorno=retorno + "D";
                } else if (numero >= 400 && numero < 500) {
                    numero -= 400;
                    retorno=retorno + "CD";
                } else if (numero >= 100 && numero < 4000) {
                    numero -= 100;
                    retorno=retorno + "C";
                } else if (numero >= 90 && numero < 100) {
                    numero -= 90;
                    retorno=retorno + "XC";
                } else if (numero >= 50 && numero < 90) {
                    numero -= 50;
                    retorno=retorno + "L";
                } else if (numero >= 40 && numero < 50) {
                    numero -= 40;
                    retorno=retorno + "XL";
                } else if (numero >= 10 && numero < 40) {
                    numero -= 10;
                    retorno=retorno + "X";
                } else if (numero == 9) {
                    numero -= 9;
                    retorno=retorno + "IX";
                } else if (numero >= 5 && numero < 9) {
                    numero -= 5;
                    retorno=retorno + "V";
                } else if (numero == 4) {
                    numero -= 4;
                    retorno=retorno + "IV";
                } else if (numero >= 1 && numero < 4) {
                    numero -= 1;
                    retorno=retorno + "I";
                }
            }
        } else retorno = "Solo se pueden convertir números entre 1 y 2000.";

        return retorno;
    }

}
