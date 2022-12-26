package com.bootcamp.covid.service;

import com.bootcamp.covid.dto.response.SintomaResponseDto;
import com.bootcamp.covid.model.Sintoma;
import com.bootcamp.covid.repository.SintomaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SintomaService implements ISintomaService{

    @Autowired
    private SintomaRepository sintomaRepository;

    /*
    public SintomaService() {
        sintomaRepository = new SintomaRepository();
    }
     */

    public List<SintomaResponseDto> findSympton() {
        return sintomaRepository.sintomas().stream().
                map(s -> new SintomaResponseDto(s.getCodigo(),s.getNombre(),s.getNivel_de_gravedad()))
                .collect(Collectors.toList());
    }

    public SintomaResponseDto findSympton(String nombre) {
        Optional<Sintoma> sintoma = sintomaRepository.sintomas().stream()
                .filter(s -> s.getCodigo().equals(nombre)).findAny();
        System.out.println(nombre);
        if (sintoma.isPresent()) {
            return new SintomaResponseDto(sintoma.get().getCodigo(),sintoma.get().getNombre(),sintoma.get().getNivel_de_gravedad());
        } else {
            return null;
        }
    }

}
