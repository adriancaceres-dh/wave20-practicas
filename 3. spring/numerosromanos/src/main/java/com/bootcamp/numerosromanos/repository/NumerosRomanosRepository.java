package com.bootcamp.numerosromanos.repository;

import com.bootcamp.numerosromanos.services.NumerosRomanosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class NumerosRomanosRepository {


    private Map<String, String>  numeros = new HashMap<>();

    public String getRomano(String numero){
        numeros.put("1", "I");
        numeros.put("2", "II");
        numeros.put("3", "III");
        numeros.put("4", "IV");
        numeros.put("5", "V");
        numeros.put("6", "VI");
        numeros.put("7", "VII");
        numeros.put("8", "VIII");
        numeros.put("9", "IX");
        numeros.put("10", "X");
        numeros.put("20", "XX");
        numeros.put("30", "XXX");
        numeros.put("40", "XL");
        numeros.put("50", "L");
        numeros.put("60", "LX");
        numeros.put("70", "LXX");
        numeros.put("80", "LXXX");
        numeros.put("90", "XC");
        numeros.put("100", "C");
        numeros.put("500", "D");
        numeros.put("1000", "M");


        return numeros.get(numero);
    }


}
