package com.spring.covid19.service;

import com.spring.covid19.dto.SintomaDTO;
import com.spring.covid19.repository.SintomaRepository;

import java.util.List;
import java.util.Objects;

public class SintomaService {

    public static List<SintomaDTO> obtenerTodosSintomas(){
        return SintomaRepository.getSintomaDTOS();
    }

    public static Integer encontrarSintoma(String nombre){
        SintomaDTO sintoma = SintomaRepository.getSintomaDTOS().stream().filter(sintomaDTO -> sintomaDTO.getNombre().equals(nombre)).findFirst().orElse(null);
        return Objects.isNull(sintoma) ? -1 : sintoma.getNivelDeGravedad();
    }
}
