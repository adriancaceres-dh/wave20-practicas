package com.example.sintomas.services;

import com.example.sintomas.dtos.SintomaDto;
import com.example.sintomas.exceptions.NotFoundException;
import com.example.sintomas.repositories.SintomasRepository;

import java.util.Collection;
import java.util.Set;

public class SintomaService {
    private static SintomasRepository _repo = new SintomasRepository();
    public Collection<SintomaDto> getAll(){
        return _repo.getSintomas().stream()
                .map(sintoma -> new SintomaDto(sintoma.getNombre(), sintoma.getNivel_de_gravedad()))
                .toList();
    }
    public SintomaDto getByName(String name){
        return _repo.getSintomas().stream()
                .filter(sintoma -> sintoma.getNombre().equalsIgnoreCase(name))
                .map(sintoma -> new SintomaDto(sintoma.getNombre(), sintoma.getNivel_de_gravedad()))
                .findFirst().orElseThrow(() -> new NotFoundException(name));
    }

    public Collection<SintomaDto> getByIds(Set<Integer> ids){
        return _repo.getSintomas().stream()
                .filter(sintoma -> ids.contains(sintoma.getCodigo()))
                .map(sintoma -> new SintomaDto(sintoma.getNombre(), sintoma.getNivel_de_gravedad())).toList();
    }
}
