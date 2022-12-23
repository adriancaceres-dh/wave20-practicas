package com.bootcamp.ejerciciospring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumeroRomano {

    @GetMapping("/convertir/{numero}")
    public String convertirRomano(@PathVariable int numero) {
        String numeRomano = "";

        int dec = 0, uni = 0, cen = 0, um = 0;
        uni = numero % 10;
        um = (numero - uni) / 1000;
        cen = (numero - uni - (um * 1000)) / 100;
        dec = (numero - uni - (um * 1000) - (cen * 100)) / 10;
        numeRomano = unidades(uni);
        numeRomano = decenas(dec) + numeRomano;
        numeRomano = centenas(cen) + numeRomano;
        numeRomano = unidadesMil(um) + numeRomano;
        return numeRomano;
    }

    public String unidades(int unidad) {
        String unidadRomano[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return unidadRomano[unidad];
    }

    public String decenas(int decena) {
        String decrom[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        return decrom[decena];
    }

    public String centenas(int centena) {
        String cenrom[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        return cenrom[centena];
    }

    public String unidadesMil(int unidadMil) {
        String unidadesMil[] = {"", "M", "MM", "MMM", "", "", "", "", "", ""};
        return unidadesMil[unidadMil];
    }
}
