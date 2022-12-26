package com.bootcamp.starwars.service;

import com.bootcamp.starwars.dto.CharacterDTO;
import com.bootcamp.starwars.repo.CharacterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StarwarsService {
    @Autowired
    private CharacterRepo characterRepo;

    public List<CharacterDTO> findCharacter (String search) {
        return characterRepo.findAllCharacters (search);
    }
}
