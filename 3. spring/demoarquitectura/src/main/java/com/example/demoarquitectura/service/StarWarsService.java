package com.example.demoarquitectura.service;

import com.example.demoarquitectura.dto.CharacterDTO;
import com.example.demoarquitectura.exceptions.NotFoundName;
import com.example.demoarquitectura.repository.DataRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StarWarsService {

    private DataRepository dataRepository;

    public StarWarsService(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    public List<String> names(String name) {
        List<String> list = dataRepository.nameStarWars(name).stream().map(CharacterDTO::getName).collect(Collectors.toList());
        if (list.isEmpty()) {
            throw new NotFoundName("Está vacío, no se encontró un nombre");
        }
        return list;
    }


}
