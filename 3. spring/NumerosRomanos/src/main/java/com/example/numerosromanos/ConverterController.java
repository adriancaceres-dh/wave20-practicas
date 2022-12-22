package com.example.numerosromanos;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

@RestController
public class ConverterController {
  private TreeMap<Integer, String> diccionario = new TreeMap<>()

  {
    {
      put(1000, "M");
      put(900, "CM");
      put(500, "D");
      put(400, "CD");
      put(100, "C");
      put(90, "XC");
      put(50, "L");
      put(40, "XL");
      put(10, "X");
      put(9, "IX");
      put(5, "V");
      put(4, "IV");
      put(1, "I");
    }
  };

  @GetMapping("/convertir/{number}")
  public String convertToRoman(@PathVariable Integer number) {
    int l =  diccionario.floorKey(number);
    if ( number == l ) {
      return diccionario.get(number);
    }

    return diccionario.get(l) + convertToRoman(number-l);
  }




}
