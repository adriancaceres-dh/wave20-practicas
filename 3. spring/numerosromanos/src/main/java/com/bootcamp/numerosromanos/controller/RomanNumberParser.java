package com.bootcamp.numerosromanos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RomanNumberParser {

    @GetMapping("/{decimal}")
    public String convertirRomanos(@PathVariable int decimal){
        StringBuilder numeroRomano = new StringBuilder();
        int auxDecimal = decimal;
        if(decimal >3000) return "Número Inválido: Mayor a 3000";
        if(decimal < 1) return "Número Invalido: Menor que cero";

        while (auxDecimal > 0) {
            if(auxDecimal>=1000){
                numeroRomano.append("M");
                auxDecimal -=1000;
            }
            else if(auxDecimal>=500){
                numeroRomano.append("D");
                auxDecimal -=500;
            }
            else if(auxDecimal>=100){
                auxDecimal -=100;
                if(numeroRomano.toString().contains("CCC"))  {
                    numeroRomano.replace(numeroRomano.length()-4, numeroRomano.length()-1, "CD");
                }else{
                    numeroRomano.append("C");
                }
            }
            else if(auxDecimal>=50){
                auxDecimal -=50;
                if(numeroRomano.toString().contains("LLL"))  {
                    numeroRomano.replace(numeroRomano.length()-4, numeroRomano.length()-1, "LC");
                }else{
                    numeroRomano.append("L");
                }
            }
            else if(auxDecimal>=10){
                auxDecimal -=10;
                if(numeroRomano.toString().contains("XXX"))  {
                    numeroRomano.replace(numeroRomano.length()-4, numeroRomano.length()-1, "XL");
                }else{
                    numeroRomano.append("X");
                }
            }
            else if(auxDecimal>=5){
                numeroRomano.append("V");
                auxDecimal -=5;
            }
            else if(auxDecimal>=1){
                auxDecimal -=1;
                if(numeroRomano.toString().contains("III"))  {
                    numeroRomano.replace(numeroRomano.length()-4, numeroRomano.length()-1, "IV");
                }else{
                    numeroRomano.append("I");
                }
            }
        }


        return "El número "+ decimal+ " equivale a "+numeroRomano+ " en números romanos. ";

    }

}
