package com.example.numerosromanos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class NumerosRomanosApplication {

    public static void main(String[] args) {
        SpringApplication.run(NumerosRomanosApplication.class, args);
    }

    // Se realizará un algoritmo recursivo para la resolución de este ejercicio.
    @GetMapping("/{numeroDecimal}")
    public String convertirNumerosDecimalesARomanos(@PathVariable String numeroDecimal) {
        return recursivoRomano(numeroDecimal);
    }

    public static String recursivoRomano(String numero){
        // Pasamos el número a un entero.
        int actual = Integer.parseInt(numero);
        String numeroMostrar = "";
        if (actual <= 0) {
            // Paso Base.
            return numeroMostrar;
        } else {
            switch (actual) {
                case 1:
                    numeroMostrar = "I" + recursivoRomano((actual - 1) + "");
                    break;
                case 2:
                    numeroMostrar = "II" + recursivoRomano((actual - 2) + "");
                    break;
                case 3:
                    numeroMostrar = "III" + recursivoRomano((actual - 3) + "");
                    break;
                case 4:
                    numeroMostrar = "IV" + recursivoRomano((actual - 4) + "");
                    break;
                default:
                    if (actual >= 5 && actual < 10) {
                        numeroMostrar = "V" + recursivoRomano((actual - 5) + "");
                    } else if (actual >= 10 && actual < 50) {
                        numeroMostrar = "X" + recursivoRomano((actual - 10) + "");
                    } else if (actual >= 50 && actual < 100) {
                        numeroMostrar = "L" + recursivoRomano((actual - 50) + "");
                    } else if (actual >= 100 && actual < 500) {
                        numeroMostrar = "C" + recursivoRomano((actual - 100) + "");
                    } else if (actual >= 500 && actual < 100) {
                        numeroMostrar = "D" + recursivoRomano((actual - 500) + "");
                    } else{
                        numeroMostrar = "M" + recursivoRomano((actual - 1000) + "");
                    }
                    break;
            }
        }
        // Devolvemos los casos revursivos.
        return numeroMostrar;
    }
}
