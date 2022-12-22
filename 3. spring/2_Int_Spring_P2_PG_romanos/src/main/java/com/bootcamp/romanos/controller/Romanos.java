package com.bootcamp.romanos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class Romanos {

    TreeMap<Integer,String> mapRomanos;

    public Romanos() {
        this.mapRomanos = new TreeMap<Integer,String>();

        mapRomanos.put(1000, "M");
        mapRomanos.put(900, "CM");
        mapRomanos.put(500, "D");
        mapRomanos.put(400, "CD");
        mapRomanos.put(100, "C");
        mapRomanos.put(90, "XC");
        mapRomanos.put(50, "L");
        mapRomanos.put(40, "XL");
        mapRomanos.put(10, "X");
        mapRomanos.put(9, "IX");
        mapRomanos.put(5, "V");
        mapRomanos.put(4, "IV");
        mapRomanos.put(1, "I");
    }

    @GetMapping("/toRoman/{decimal}")
    public String decimalToRomans(@PathVariable int decimal){
        //mapRomanos.entrySet().stream().

        int l =  mapRomanos.floorKey(decimal);
        if ( decimal == l ) {
            return mapRomanos.get(decimal);
        }
        return mapRomanos.get(l) + decimalToRomans(decimal-l);
    }
}
