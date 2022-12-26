package com.main.StarWarsApp.services;

import com.main.StarWarsApp.dtos.CharacterDTO;
import com.main.StarWarsApp.repositories.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
public class CharacterService {

    @Autowired
    CharacterRepository repository;

    public List<CharacterDTO> findAll(){
        return repository.findAll();
    }

    public List<CharacterDTO> findAny(String name) {
        return repository.findAny(name);
    }
}
