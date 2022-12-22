package com.bootcamp.primerprueba.ConversorNumeros.Conversor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConversorRestController {
  @GetMapping("/{num}")
  public String toRoman(@PathVariable int num) {
    //Un StringBuilder optimiza espacio en memoria ya que concatenar con un + no es lo mas apropiado.
    StringBuilder numRomano = new StringBuilder();
    // Creamos un array de numeros decimales bases.
    int[] numDecimales = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] numRomanos = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    if(num == 0){
      return "No existe.";
    }

    for(int i=0; i<numDecimales.length;i++){
        while (num >= numDecimales[i]) {
          num = num - numDecimales[i];
          numRomano.append(numRomanos[i]);
        }
      }
    return numRomano.append(" es el equivalente en numeros romanos.").toString();
  }
}
