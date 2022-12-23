package com.bootcamp.fechanacimiento.service;

import java.time.LocalDate;
import java.time.Period;

public class FechanacimientoService {

    public static int calcularFecha(String dia, String mes, String anno) {
        LocalDate fechaRecibida = LocalDate.parse(String.format("%s-%s-%s", anno, mes, dia));
        return Period.between(fechaRecibida,LocalDate.now()).getYears();
    }


}
