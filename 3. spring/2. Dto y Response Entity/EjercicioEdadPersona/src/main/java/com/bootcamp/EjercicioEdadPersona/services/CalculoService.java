package com.bootcamp.EjercicioEdadPersona.services;

import org.springframework.stereotype.Service;

import java.util.Calendar;

@Service
public class CalculoService {

    public Integer calcularEdad (int ano, int mes, int dia){

        // Seteamos el dia mes y año
        Calendar inicio = Calendar.getInstance();
        inicio.set(ano, mes - 1, dia);

        // Dia actual
        Calendar actual = Calendar.getInstance();

        // Si la diferencia de años es 0, no hay que restar nada
        // Si el año del dia de la fecha que yo paso es mayor que la actual, resto uno
        Integer diff = actual.get(Calendar.YEAR) - inicio.get(Calendar.YEAR);

        if (inicio.get(Calendar.MONTH) > actual.get(Calendar.MONTH) ||
                (inicio.get(Calendar.MONTH) == actual.get(Calendar.MONTH) &&
                        inicio.get(Calendar.DATE) > actual.get(Calendar.DATE))) {
            diff--;
        }

        return diff;

    }
}
