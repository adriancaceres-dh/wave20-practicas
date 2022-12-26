package com.bootcamp.EdadDeUnaPersona.Servicies;

import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Service
public class ServicioCalculadorEdad implements IServicioCalculadorEdad {

    // El código proviene de https://www.lawebdelprogramador.com/codigo/Java/3902-Comprobar-que-una-fecha-sea-correcta.html#:~:text=Para%20que%20una%20fecha%20sea%20correcta%20es%20necesario%3A&text=El%20a%C3%B1o%20debe%20ser%20mayor%20que%20cero.&text=El%20mes%20debe%20estar%20entre%201%20y%2012.&text=Dependiendo%20del%20mes%20que%20sea,dentro%20de%20los%20l%C3%ADmites%20v%C3%A1lidos.
    public static boolean validarFecha(String fecha) {
        try {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
            formatoFecha.setLenient(false);
            formatoFecha.parse(fecha);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public long calcularEdadAPartirDeFecha(String dia, String mes, String ano) {
        String fecha = ano + "-" + mes + "-" + dia; // Solo funciona si posee este formato de entrada en LocalDate.parse.
        String fechaValidar = dia + "/" + mes + "/" + ano; // Para que verificador pueda funcionar correctamente debe estar en este formato.
        if (validarFecha(fechaValidar)) {
            return ChronoUnit.YEARS.between(LocalDate.parse(fecha), LocalDate.now());
        }
        return 0;
    }
}
