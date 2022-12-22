package com.example.numerosromanos.controller;


import com.example.numerosromanos.excepcion.ElementoNoEncontradoException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Convertor")
public class ConvertorController {

    @GetMapping("/Decimal")
    public int romanoADecimal(@RequestParam(value = "numero") String NumeroRomano){
        int resultado = 0;
        char[] NumeroRomanoAux = NumeroRomano.toCharArray();

        for (int i = 0; i < NumeroRomanoAux.length; i++) {

            int v1 = valorNumerico(NumeroRomanoAux[i]);

            if (i + 1 < NumeroRomanoAux.length) {

                int v2 = valorNumerico(NumeroRomanoAux[i + 1]);

                if (v1 >= v2) {
                    resultado = resultado + v1;
                }
                else {
                    resultado = resultado + v2 - v1;
                    i++;
                }
            }
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
                throw new ElementoNoEncontradoException("No representa numeros romanos" );
        }
    }


}
