package com.spring.covid19.repository;

import com.spring.covid19.dto.SintomaDTO;

import java.util.ArrayList;
import java.util.List;

public class SintomaRepository {
    private static List<SintomaDTO> sintomaDTOS = new ArrayList<>();

    public static void cargarSintomas(){
        SintomaDTO sintoma1 = new SintomaDTO("sintoma 1", 1);
        SintomaDTO sintoma2 = new SintomaDTO("sintoma 2", 2);
        SintomaDTO sintoma3 = new SintomaDTO("sintoma 3", 3);
        sintomaDTOS.add(sintoma1);
        sintomaDTOS.add(sintoma2);
        sintomaDTOS.add(sintoma3);
    }

    public static List<SintomaDTO> getSintomaDTOS() {
        return sintomaDTOS;
    }

    public static void setSintomaDTOS(List<SintomaDTO> sintomasDto) {
        SintomaRepository.sintomaDTOS = sintomaDTOS;
    }
}
