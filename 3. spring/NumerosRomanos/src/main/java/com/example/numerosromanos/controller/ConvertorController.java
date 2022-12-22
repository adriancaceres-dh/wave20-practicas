package com.example.numerosromanos.controller;


import com.example.numerosromanos.excepcion.ElementoNoEncontradoException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Convertor")
public class ConvertorController {

    @GetMapping("/Decimal")
    public int romanoADecimal(@RequestParam(value = "numero", defaultValue = "0") String NumeroRomano){
        int resultado = 0;
        char[] NumeroRomanoAux = NumeroRomano.toCharArray();

        for (int i = 0; i < NumeroRomanoAux.length; i++) {

            int v1 = valorNumerico(NumeroRomanoAux[i]);

            //Toma en cuenta la posible existencia de un siguiente valor
            if (i + 1 < NumeroRomanoAux.length) {

                int v2 = valorNumerico(NumeroRomanoAux[i + 1]);

                //Si el siguiente valor es menor, suma el actual
                if (v1 >= v2) {
                    resultado = resultado + v1;
                }
                //Si el siguiente valor es mayor, suma la diferencia entre ambos
                // y avanza el contador para que no lo tome en cuenta el proximo ciclo
                else {
                    resultado = resultado + v2 - v1;
                    i++;
                }
            }
            //Si no existe un siguiente valor, le suma el ultimo caracter del numero al resultado
            else {
                resultado = resultado + v1;
            }
        }
        return resultado;

    }
    private int valorNumerico(char NumeroRomano){
        switch (NumeroRomano){
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                throw new ElementoNoEncontradoException("El caracter "+ NumeroRomano +" no representa un numero romano" );
        }
    }


}
