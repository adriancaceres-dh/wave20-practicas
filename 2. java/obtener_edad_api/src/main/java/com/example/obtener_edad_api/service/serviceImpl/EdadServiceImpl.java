package com.example.obtener_edad_api.service.serviceImpl;

import com.example.obtener_edad_api.service.EdadService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class EdadServiceImpl implements EdadService {

    LocalDate localDate;

    public EdadServiceImpl(){
        localDate = LocalDate.now();
    }

    @Override
    public int calcularEdad(int dia, int mes, int anno) {

        int edad = 0;

        edad += localDate.getYear()-anno;
        if(mes > localDate.getMonth().getValue()){
            edad -= 1;
        } else if(mes == localDate.getMonth().getValue()){
            if(dia > localDate.getDayOfMonth()){
                edad -= 1;
            }
        }

        return edad;
    }
}
