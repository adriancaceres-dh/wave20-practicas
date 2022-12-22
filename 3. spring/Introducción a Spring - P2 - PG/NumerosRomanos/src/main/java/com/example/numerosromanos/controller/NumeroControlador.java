package com.example.numerosromanos.controller;

import com.example.numerosromanos.entity.Numero;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class NumeroControlador {


    @GetMapping("/numero/{numeroDecimalAConvertir}")
    public String convertirANumeroRomano(@PathVariable int numeroDecimalAConvertir) {
        String numeroRomano = "";
        Numero numeroConversor = new Numero();
        if (numeroDecimalAConvertir < 900) {
            numeroRomano += agregarCentenas(numeroConversor, numeroDecimalAConvertir);
        } else if (numeroDecimalAConvertir < 1000) {
            int aux = numeroDecimalAConvertir - 900;
            int digito = aux % 1000;
            numeroRomano += numeroConversor.devolverNumeroRomano(100);
            numeroRomano += numeroConversor.devolverNumeroRomano(1000);
            numeroRomano += agregarCentenas(numeroConversor, digito);
        } else if (numeroDecimalAConvertir == 1000) {
            numeroRomano += numeroConversor.devolverNumeroRomano(1000);
        }
        return numeroRomano;
    }

    public String agregarCentenas(Numero numeroConversor, int numeroDecimalAConvertir) {
        String numeroRomano = "";
        if (numeroDecimalAConvertir < 100) {
            numeroRomano += agregarDecenas(numeroConversor, numeroDecimalAConvertir);
        } else if (numeroDecimalAConvertir < 400) {
            int digito = numeroDecimalAConvertir % 100;
            int cantX = numeroDecimalAConvertir / 100;
            for (int i = 0; i < cantX; i++) {
                numeroRomano += numeroConversor.devolverNumeroRomano(100);
            }
            numeroRomano += agregarDecenas(numeroConversor, digito);
        } else if (numeroDecimalAConvertir < 500) {
            int digito = numeroDecimalAConvertir % 100;
            numeroRomano += numeroConversor.devolverNumeroRomano(100);
            numeroRomano += numeroConversor.devolverNumeroRomano(500);
            numeroRomano += agregarDecenas(numeroConversor, digito);
        } else if (numeroDecimalAConvertir < 900) {
            int aux = numeroDecimalAConvertir - 500;
            int digito = aux % 100;
            int cantX = aux / 100;
            numeroRomano += numeroConversor.devolverNumeroRomano(500);
            for (int i = 0; i < cantX; i++) {
                numeroRomano += numeroConversor.devolverNumeroRomano(100);
            }
            numeroRomano += agregarDecenas(numeroConversor, digito);
        }
        return numeroRomano;
    }

    public String agregarDecenas(Numero numeroConversor, int numeroDecimalAConvertir) {
        String numeroRomano = "";
        if (numeroDecimalAConvertir == 0) {
            numeroRomano = "";
        } else if (numeroDecimalAConvertir <= 10) {
            numeroRomano = numeroConversor.devolverNumeroRomano(numeroDecimalAConvertir);
        } else if (numeroDecimalAConvertir < 40) {
            int digito = numeroDecimalAConvertir % 10;
            int cantX = numeroDecimalAConvertir / 10;
            for (int i = 0; i < cantX; i++) {
                numeroRomano += numeroConversor.devolverNumeroRomano(10);
            }
            numeroRomano += agregarDigito(numeroConversor, digito);

        } else if (numeroDecimalAConvertir < 50) {
            int digito = numeroDecimalAConvertir % 10;
            numeroRomano += numeroConversor.devolverNumeroRomano(10);
            numeroRomano += numeroConversor.devolverNumeroRomano(50);
            numeroRomano += agregarDigito(numeroConversor, digito);
        } else if (numeroDecimalAConvertir < 90) {
            int aux = numeroDecimalAConvertir - 50;
            int digito = aux % 10;
            int cantX = aux / 10;
            numeroRomano += numeroConversor.devolverNumeroRomano(50);
            for (int i = 0; i < cantX; i++) {
                numeroRomano += numeroConversor.devolverNumeroRomano(10);
            }
            numeroRomano += agregarDigito(numeroConversor, digito);
        } else if (numeroDecimalAConvertir < 100) {
            int digito = numeroDecimalAConvertir % 10;
            numeroRomano += numeroConversor.devolverNumeroRomano(10);
            numeroRomano += numeroConversor.devolverNumeroRomano(100);
            numeroRomano += agregarDigito(numeroConversor, digito);
        }
        return numeroRomano;
    }

    public String agregarDigito(Numero numeroConversor, int digito) {
        if (digito != 0) {
            return numeroConversor.devolverNumeroRomano(digito);
        }
        return "";
    }
}
