package com.ejercicionumroman.numerosromanos;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class NumerosRomanos {
    @GetMapping("/{numero}")
    public String convertiromano(@PathVariable int numero) {
        String result = null;
        String string = "I";
        int count = numero;
        if (numero >= 1 && numero < 4) {
            result = "El número ingresado: " + numero + ", es en número romano: " + string.repeat(count);
        } else if (numero==4){
            result = "El número ingresado: " + numero + ", es en número romano: IV";
                } else if (numero==5){
            result = "El número ingresado: " + numero + ", es en número romano: V";
                } else if(numero>5 && numero<= 9) {
            result = "El número ingresado: " + numero + ", es en número romano: V" + string.repeat(count - 5);
        } else if (numero==10){
            result = "El número ingresado: " + numero + ", es en número romano: X";
        } else if (numero>10 && numero<=13){
            result = "El número ingresado: " + numero + ", es en número romano: X" + string.repeat(count - 10);
        } else if (numero==50){
            result = "El número ingresado: " + numero + ", es en número romano: L";
        }else if (numero==100){
            result = "El número ingresado: " + numero + ", es en número romano: C";
        }else if (numero==500){
            result = "El número ingresado: " + numero + ", es en número romano: D";
        }else if (numero==1000){
            result = "El número ingresado: " + numero + ", es en número romano: M";
        } else{
            result = "El sistema no soporta el número ingresado, por favor comuniquese con su administrador";
        }

        return result;
    }
}
