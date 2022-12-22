package com.example.codigomorse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class CodigoMorseController {

  private Map<String, String> diccionario = new HashMap<>() {
    {
      put(".-", "A");
      put("-...", "B");
      put("-.-.", "C");
      put("-..", "D");
      put(".", "E");
      put("..-.", "F");
      put("--.", "G");
      put("....", "H");
      put("..", "I");
      put(".---", "J");
      put("-.-", "K");
      put(".-..", "L");
      put("--", "M");
      put("-.", "N");
      put("---", "O");
      put(".--.", "P");
      put("--.-", "Q");
      put(".-.", "R");
      put("...", "S");
      put("-", "T");
      put("..-", "U");
      put("...-", "V");
      put(".--", "W");
      put("-..-", "X");
      put("-.--", "Y");
      put("--..", "Z");
      put("-----", "0");
      put(".----", "1");
      put("..---", "2");
      put("...--", "3");
      put("....-", "4");
      put(".....", "5");
      put("-....", "6");
      put("--...", "7");
      put("---..", "8");
      put("----.", "9");
    }
  };

  @GetMapping("/traducir/{codigo}")
  public String traducir(@PathVariable String codigo) {
    String frase = "";
    for (String palabra : codigo.split("   ")) {
      String[] letras = palabra.split(" ");
      String resultado = "";
      for (String letra : letras) {
        resultado += diccionario.get(letra);
      }
      frase += resultado + " ";
    }
    return frase;
  }
}
