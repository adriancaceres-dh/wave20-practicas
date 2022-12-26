package com.bootcamp.numerosromanos.services;

import com.bootcamp.numerosromanos.repository.NumerosRomanosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class NumerosRomanosService {

    @Autowired
    private NumerosRomanosRepository numerosRomanosRepository;



    public String getNumeroRomano (int numero){


        // Covertir el numero en String
        String cadenaNumero = String.valueOf(numero);
        // Covertir el numero String en un arreglo
        String[] digits = cadenaNumero.split("(?<=.)");

        String respuesta = "";

        // Buscar directamente con el numero String
        if (numero < 10) {
            respuesta = numerosRomanosRepository.getRomano(cadenaNumero);
        }
        // Buscar numeros de dos cifras que terminan en cero
        else if (digits[1].equals("0")) {
            // Buscar directamente con el numero String - 10, 20, 30...
            respuesta = numerosRomanosRepository.getRomano(cadenaNumero);
        }
        // Buscar numeros de dos cifras que terminan en un numero diferente de cero - 24, 38, 62
        else if (numero > 10 && numero < 100) {
            respuesta = numerosRomanosRepository.getRomano(digits[0] + "0") + numerosRomanosRepository.getRomano(digits[1]);
        }

        // CONTINUA PARA NUMEROS DE 3 CIFRAS

        return respuesta;

    }


}
