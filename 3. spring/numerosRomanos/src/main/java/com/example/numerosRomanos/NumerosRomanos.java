package com.example.numerosRomanos;

import java.util.ArrayList;
import java.util.List;

public class NumerosRomanos {

    public static String convertirNumero(int numero){
        int parteEntera;
        int[] numerosReferencia = {1000,900,500,400,100,90,50,40,10, 9, 5, 4, 1};
        String[] alfabeto = {"M","CM","D","CD","C","XC","L","XL", "X", "IX", "V", "IV", "I"};
        List<String> resultString=new ArrayList<>();

        for (int i = 0; i <numerosReferencia.length ; i++) {
            parteEntera=numero/numerosReferencia[i];
            if (numero==0) break;
            if (parteEntera==0 ) continue;
            numero-=numerosReferencia[i]*parteEntera;
            resultString.add(alfabeto[i].repeat(parteEntera));
        }
        return String.join("",resultString);
    }
}
