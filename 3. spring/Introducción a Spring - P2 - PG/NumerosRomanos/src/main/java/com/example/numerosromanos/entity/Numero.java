package com.example.numerosromanos.entity;

import java.util.HashMap;
import java.util.Map;

public class Numero {

    Map<Integer, String> convertorNumeros = new HashMap<>();

    public Numero() {
        convertorNumeros = new HashMap<>();
        convertorNumeros.put(1, "I");
        convertorNumeros.put(2, "II");
        convertorNumeros.put(3, "III");
        convertorNumeros.put(4, "IV");
        convertorNumeros.put(5, "V");
        convertorNumeros.put(6, "VI");
        convertorNumeros.put(7, "VII");
        convertorNumeros.put(8, "VIII");
        convertorNumeros.put(9, "IX");
        convertorNumeros.put(10, "X");
        convertorNumeros.put(50, "L");
        convertorNumeros.put(100, "C");
        convertorNumeros.put(500, "D");
        convertorNumeros.put(1000, "M");
    }

    public Map<Integer, String> getConvertorNumeros() {
        return convertorNumeros;
    }

    public void setConvertorNumeros(Map<Integer, String> convertorNumeros) {
        this.convertorNumeros = convertorNumeros;
    }

    public String devolverNumeroRomano(int key){
        return convertorNumeros.get(key);
    }
}
