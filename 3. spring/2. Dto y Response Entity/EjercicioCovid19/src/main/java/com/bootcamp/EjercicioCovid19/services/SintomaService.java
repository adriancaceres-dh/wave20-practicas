package com.bootcamp.EjercicioCovid19.services;

import com.bootcamp.EjercicioCovid19.models.Sintoma;
import com.bootcamp.EjercicioCovid19.repositories.SintomaRepository;
import com.bootcamp.EjercicioCovid19.DTOs.SintomaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SintomaService {
    @Autowired
    SintomaRepository sintomaRepository;

    public List<SintomaDto> getSintomas(){
        List<SintomaDto> sintomas = new ArrayList<>();
        this.sintomaRepository.getSintomas().stream().
                forEach(sintoma ->
                        sintomas.add(
                                new SintomaDto(sintoma.getNombre(),sintoma.getCodigo(),sintoma.getNivel_de_gravedad())
                        )
                );
        return sintomas;
    }

    public SintomaDto busquedaSintoma(String nombre){
        Sintoma sintoma = sintomaRepository.busquedaSintoma(nombre);
        return new SintomaDto(sintoma.getNombre(),sintoma.getCodigo(), sintoma.getNivel_de_gravedad());
    }
}
